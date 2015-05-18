package webapp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSParser {

	private String urlFeed;

	public RSSParser(String urlFeed) {
		this.urlFeed = urlFeed;
	}

	public List<HashMap<String, String>> getContent() throws Exception {
		URL url = new URL(urlFeed);
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();

		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List<SyndEntry> entries = new ArrayList<SyndEntry>();

		for (Object syndEntry : feed.getEntries()) {
			entries.add((SyndEntry) syndEntry);
		}

		Iterator<SyndEntry> itEntries = entries.iterator();
		List<HashMap<String, String>> info = new ArrayList<HashMap<String, String>>();

		while (itEntries.hasNext()) {
			SyndEntry entry = itEntries.next();
			Map<String, String> news = new HashMap<String, String>();
			news.put("Title", entry.getTitle());
			news.put("Link", entry.getLink());
			news.put("Author", entry.getAuthor());
			news.put("PublishDate", entry.getPublishedDate().toString());
			news.put("Description", entry.getDescription().getValue());
			info.add((HashMap<String, String>) news);
		}

		return info;
	}

}
