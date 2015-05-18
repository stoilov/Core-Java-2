package webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {

	private List<String> visited = new ArrayList<String>();
	private Queue<String> toVisit = new LinkedList<String>();

	String domain;

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
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	public void crawl(String url, String needle) {
		domain = getDomain(url);
		toVisit.add(url);

		while (toVisit.size() > 0) {

			String link = toVisit.poll();
			String result = crawlingInfo(link, needle);

			if (result != null) {
				System.out.println("RESULT: " + result);
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
	}
}
