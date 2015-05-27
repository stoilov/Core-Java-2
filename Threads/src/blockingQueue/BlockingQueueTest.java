package blockingQueue;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<String>();
		
		String polled = null;
		try {
			polled = queue.poll();
			queue.add("Hello");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(polled);
	}
	
}
