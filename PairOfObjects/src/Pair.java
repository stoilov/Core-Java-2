final public class Pair {
	final private Object leftObj;
	final private Object rightObj;
	
	private void check(Object obj1, Object obj2){
		if (obj1 == null || obj2 == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public Pair(Object leftObj, Object rightObj) {
		check(leftObj, rightObj);
		this.leftObj = leftObj;
		this.rightObj = rightObj;
	}
	
	public Object getLeftObj() {
		return leftObj;
	}
	
	public Object getRightObj() {
		return rightObj;
	}
	
	@Override
	public String toString() {
		return String.format("(%s : %s, %s : %s)",
				getLeftObj().toString(), getLeftObj().getClass().toString(),
				getRightObj().toString(), getRightObj().getClass().toString());
	}
	
	public boolean equals(Pair secondPair) {
		boolean leftComparison, rightComparison;
		
		leftComparison = getLeftObj().equals(secondPair.getLeftObj());
		rightComparison = getRightObj().equals(secondPair.getRightObj());
		
		return leftComparison && rightComparison;
	}
	
}
