package atomicInteger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyAtomicInt extends Number {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6293512251875905859L;

	int value;

	private final Lock lock = new ReentrantLock();

	public MyAtomicInt(int initialValue) {
		value = initialValue;
	}

	public MyAtomicInt() {
		this(0);
	}

	@Override
	public double doubleValue() {
		return (double) value;
	}

	@Override
	public float floatValue() {
		return (float) value;
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	public final int incrementAndGet() {
		lock.lock();
		value++;
		lock.unlock();
		return value;
	}

	public final int decrementAndGet() {
		lock.lock();
		value--;
		lock.unlock();
		return value;
	}

}
