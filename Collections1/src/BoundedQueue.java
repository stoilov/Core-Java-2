import java.util.List;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class BoundedQueue<E> extends AbstractQueue<E> {

	private int maxSize;
	private List<E> queueList = new ArrayList<>();

	public BoundedQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
	}

	@Override
	public boolean offer(E e) {
		if (queueList.size() < maxSize) {
			queueList.add(e);
			return true;
		}
		return false;
	}

	@Override
	public E peek() {
		if (queueList.size() != 0) {
			return queueList.get(0);
		}
		return null;
	}

	@Override
	public E poll() {
		if (queueList.size() != 0) {
			E polled = queueList.get(0);
			queueList.remove(0);
			return polled;
		}
		return null;
	}

	@Override
	public int size() {
		return queueList.size();
	}

	@Override
	public Iterator<E> iterator() {
		return queueList.iterator();
	}

}