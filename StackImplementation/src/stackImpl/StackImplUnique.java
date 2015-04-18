package stackImpl;

public class StackImplUnique extends StackImpl {

	public StackImplUnique(int size) {
		super(size);
	}
	
	private boolean hasElement(Object obj) {
		for (int i = 0; i < getStack().length; i++) {
			if (obj.equals(getStack()[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean push(Object obj) {
		if (!hasElement(obj)) {
			super.push(obj);
			return true;
		}
		return false;
	}

}
