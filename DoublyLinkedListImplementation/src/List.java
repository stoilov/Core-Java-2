import java.util.ArrayList;

public class List implements DoublyLinkedList {

	private ArrayList<ListNodes> nodesList = new ArrayList<ListNodes>();
	private int lastElementIndex;

	public List() {
		lastElementIndex = -1;
	}

	@Override
	public void add(int value) {
		ListNodes element = new ListNodes(value);
		
		if (lastElementIndex != -1) {
			ListNodes lastNode = nodesList.get(lastElementIndex);
			lastNode.setNextNode(element);
			element.setPreviousNode(lastNode);
		}
		
		lastElementIndex++;
		nodesList.add(element);
	}

	@Override
	public int remove(int elementIndex) {
		ListNodes removed = nodesList.get(elementIndex);
		
		if (elementIndex != lastElementIndex) {
			ListNodes afterRemoved = nodesList.get(elementIndex + 1);
			afterRemoved.setPreviousNode(removed.getPreviousNode());
		}
		
		if(elementIndex != 0) {
			ListNodes beforeRemoved = nodesList.get(elementIndex - 1);
			beforeRemoved.setNextNode(removed.getNextNode());
		}
		
		nodesList.remove(elementIndex);
		
		lastElementIndex--;
		return removed.getValue();
	}

	@Override
	public int size() {
		return lastElementIndex + 1;
	}

	@Override
	public int get(int elementIndex) {
		return nodesList.get(elementIndex).getValue();
	}

	@Override
	public int getHead() {
		return nodesList.get(0).getValue();
	}

	@Override
	public int getTail() {
		return nodesList.get(lastElementIndex).getValue();
	}

}
