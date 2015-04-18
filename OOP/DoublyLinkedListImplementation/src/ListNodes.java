public class ListNodes {

	private int value;
	private ListNodes previousNode;
	private ListNodes nextNode;

	ListNodes(int value) {
		setValue(value);
	}

	int getValue() {
		return value;
	}

	void setValue(int value) {
		this.value = value;
	}

	ListNodes getPreviousNode() {
		return previousNode;
	}

	void setPreviousNode(ListNodes previousNode) {
		if (previousNode instanceof ListNodes) {
			this.previousNode = previousNode;
		}
	}

	ListNodes getNextNode() {
		return nextNode;
	}

	void setNextNode(ListNodes nextNode) {
		if (nextNode instanceof ListNodes) {
			this.nextNode = nextNode;
		}
	}

}
