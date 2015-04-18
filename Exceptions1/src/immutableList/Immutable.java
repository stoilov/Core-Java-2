package immutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//import org.apache.commons.lang3.SerializationUtils;

public final class Immutable<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7385934414773891823L;

	public Immutable(Collection<? extends E> collection) {
		super(collection);
	}

	public E get(int index) {
		// return SerializationUtils.clone(super.get(index));
		return super.get(index);
	}

	@Override
	public boolean add(final E e) throws ImmutableListChangeException {
		throw new ImmutableListChangeException();
	}

	@Override
	public E remove(int index) throws ImmutableListChangeException {
		throw new ImmutableListChangeException();
	}

	@SafeVarargs
	public static <T> List<T> asList(T... arguments) {
		return new Immutable<>(new ArrayList<T>(Arrays.asList(arguments)));
	}

	public void clear() throws ImmutableListChangeException {
		throw new ImmutableListChangeException();
	}

}
