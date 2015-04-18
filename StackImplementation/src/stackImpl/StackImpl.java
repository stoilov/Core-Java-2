package stackImpl;

public class StackImpl implements Stack {

	private Object[] stack;
	private int maxSize;
	private int topIndex;

	public StackImpl(int size) {
		setSize(size);
		stack = new Object[this.maxSize];
		topIndex = -1;
	}

	private void setSize(int size) {
		if (size > 0) {
			this.maxSize = size;
		} else {
			this.maxSize = 0;
		}
	}
	
	protected Object[] getStack() {
		return this.stack;
	}

	@Override
	public boolean push(Object obj) {
		topIndex++;
		stack[topIndex] = obj;
		return true;
	}

	@Override
	public Object pop() {
		Object popped = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return popped;
	}

	@Override
	public int length() {
		return topIndex + 1;
	}

	@Override
	public void clear() {
		while (topIndex > -1) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

	@Override
	public boolean isEmpty() {
		return (topIndex == -1);
	}

}
