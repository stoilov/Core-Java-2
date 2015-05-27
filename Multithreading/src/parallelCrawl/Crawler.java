package parallelCrawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {

	private List<String> visited;
	private Queue<String> toVisit;
	
	private boolean stop = false;
	
	String domain;
	String url;

	Lock lock = new ReentrantLock();

	public Crawler(String url) {
//		visited = new ArrayList<String>();
		visited = Collections.synchronizedList(new ArrayList<String>());
		toVisit = new ConcurrentLinkedQueue<String>();
		this.url = url;
		domain = getDomain(url);
	}
	
	public boolean getStop() {
		return stop;
	}

	public String readUrl(String link) {
		String result = "";
		URL page;
		BufferedReader in;
		try {
			page = new URL(link);
			in = new BufferedReader(new InputStreamReader(page.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				result += inputLine;
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException caught.");
		} catch (IOException e) {
			System.out.println("IOException caught.");
		}

		return result;
	}

	private List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}

	public String crawlingInfo(String link, String needle) {
		System.out.println(link);
		String content = readUrl(link);
		if (content.contains(needle)) {
			return link;
		}

		return null;
	}

	public String getDomain(String url) {
		String domain = null;
		String protocol = null;
		try {
			domain = new URL(url).getAuthority();
			protocol = new URL(url).getProtocol();
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException caught.");
		}

		return String.format("%s://%s", protocol, domain);
	}

	public boolean isOutgoing(String url) {
		return !getDomain(url).equals(domain);
	}

	public boolean shouldBeCrawled(String url) {

		return !visited.contains(url) || !toVisit.contains(url)
				|| !isOutgoing(url) || !url.contains("#")
				|| url.contains(domain);
	}

	public String absolutisize(String url) {
		if (url.startsWith("/") || url.startsWith("../")
				|| !url.startsWith("http")) {
			url = String.format("%s/%s", domain, url);
		}

		try {
			url = new URI(url).normalize().toString();
		} catch (URISyntaxException e) {
			System.out.println("URISyntaxException caught.");
		}

		return url;
	}

	public void crawl(String needle) {
		lock.lock();

		domain = getDomain(url);
		toVisit.add(url);

		while (toVisit.size() > 0) {

			String link = toVisit.poll();
			String result = crawlingInfo(link, needle);

			if (result != null) {
				System.out.printf("RESULT: %s\n", result);
				stop = true;
				break;
			} else {
				List<String> allLinks = getAllLinks(readUrl(link));
				for (String page : allLinks) {
					page = absolutisize(page);
					if (shouldBeCrawled(page)) {
						toVisit.add(page);
					}
				}
				visited.add(link);
			}
		}

		lock.unlock();
	}
}
