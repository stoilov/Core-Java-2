package noNullHashMap;

public class NoNullHashMapUse {

	public static void main(String[] args) {
		NoNullHashMap noNullMap = new NoNullHashMap();
		String one = "one";
		String two = "two";
		String nullStr = null;
		
		noNullMap.put(one, "1");
		noNullMap.put(two, "2");
		
//		noNullMap.put(nullStr, "3");
		
		try {
			noNullMap.put(nullStr, "3");
		} catch (NoNullKeyException e) {
			System.out.println(e.getMessage());
		}
		
		for (NoNullHashMap.Entry<Object, Object> entry : noNullMap.entrySet()) {
			System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
		}
		
	}
	
}
