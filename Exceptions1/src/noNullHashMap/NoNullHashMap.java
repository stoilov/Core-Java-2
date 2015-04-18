package noNullHashMap;

import java.util.HashMap;
import java.util.Map;

public class NoNullHashMap extends HashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean allowNullKeys;

	public NoNullHashMap() {
		super();
		this.allowNullKeys = false;
	}
		
	public NoNullHashMap(boolean allowNull) {
		super();
		this.allowNullKeys = allowNull;
	}

	@Override
	public Object put(Object key, Object value) {
		if (!allowNullKeys && key == null) {
			throw new NoNullKeyException("No null keys allowed");
		} else {
			return super.put(key, value);
		}
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		for (Map.Entry<? extends Object, ? extends Object> entry : m.entrySet()) {
			if (!allowNullKeys && entry.getKey().equals(null)) {
				throw new NoNullKeyException("No null keys allowed");
			}
		}

		super.putAll(m);
	}

}
