package blockingQueue;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> {

	private List<T> queueList = new ArrayList<T>();
	private Object obj = new Object();
	
	private T lastPulled = null;

	public T poll() {

		Thread poll = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (obj) {
					while (queueList.isEmpty()) {
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					lastPulled = queueList.get(queueList.size() - 1);
					System.out.println(lastPulled);
					queueList.remove(queueList.size() - 1);
				}
			}
		});
			
		poll.start();
		return lastPulled;
	}

	public void add(T element) throws InterruptedException {
		Thread add = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					queueList.add(element);
					obj.notifyAll();
				}
			}
		});

		add.start();
		add.join();
	}
}
