public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(Object[] values) {
		this.head = null;
		this.tail = this.head;
		nodeCount = 0;
		for (int i = 0; i < values.length; i++) {
			add((E) (values[i]));
		}
		// head = new ListNode<E>((E) values[0]);
		// tail = new ListNode<E>((E) values[nodeCount - 1]);
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode<E> n = head; n.getNext() != null; n = n.getNext()) {
			if (n.getValue().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int index = 0;
		for (ListNode<E> n = head; n.getNext() != null; n = n.getNext()) {
			if (n.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		if (obj.equals(null)) {
			return false;
		}
		ListNode<E> tempAdd = new ListNode<E>(obj);
		tail.setNext(tempAdd);
		tail = tempAdd;
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	// public boolean remove(E obj) {
	// for (ListNode<E> n = head; n.getNext() != null; n = n.getNext()) {
	// if (n.getValue().equals(obj)) {

	// }
	// }

	// Returns the i-th element.
	public E get(int i) {}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {

	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		String toReturn = "";
		for (ListNode<E> n = head; n.getNext() != null; n = n.getNext()) {
			toReturn += n.getValue().toString();
		}
		return toReturn;

	}


}
