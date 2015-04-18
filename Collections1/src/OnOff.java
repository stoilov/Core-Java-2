import java.util.ArrayList;
import java.util.List;
import java.util.AbstractCollection;
import java.util.Iterator;

public class OnOff<E> extends AbstractCollection<E> {

	private List<E> list = new ArrayList<E>();

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}

	public boolean add(E e) {
		if (e != null) {
			if (list.indexOf(e) == -1) {
				list.add(e);
			} else {
				list.remove(e);
			}
			return true;
		}
		return false;
	}

}
