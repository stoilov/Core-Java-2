package webcrawler;

public class DoCrawl {

	public static void main(String[] args) {
		Crawler crawler = new Crawler();
		crawler.crawl("http://ebusiness.free.bg", "Револвираща");
	}

}
