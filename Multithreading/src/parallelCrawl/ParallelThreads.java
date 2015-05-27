package parallelCrawl;

public class ParallelThreads {

	private static final int THREADS_NUMBER = 5;
	
	public void paralelCrawl(String url, String needle) throws InterruptedException {
		Crawler crawler = new Crawler(url);
		
		Thread[] threads = new Thread[THREADS_NUMBER];
		
		Runnable crawlRunnable = new Runnable() {

			@Override
			public void run() {
				while (!crawler.getStop()) {
					crawler.crawl(needle);
				}
			}
		};

		for (int i = 0; i < THREADS_NUMBER; i++) {
			threads[i] = new Thread(crawlRunnable);
		}

		for (int i = 0; i < THREADS_NUMBER; i++) {
			threads[i].start();
			threads[i].join();
		}
		
	}
	
	public void measureTime() {
		long start_time = System.currentTimeMillis();

		try {
			paralelCrawl("http://ebusiness.free.bg", "Револвираща");
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		long end_time = System.currentTimeMillis();

		long difference = end_time - start_time;

		System.out.printf("\nTime needed: %d milliseconds\n", difference);
	}
	
}
