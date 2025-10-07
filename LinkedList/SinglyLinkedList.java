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
		head = null;
		tail = null;
		nodeCount = 0;
		for (int i = 0; i < values.length; i++) {
			add((E) (values[i]));
		}
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
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (obj == null) {
				if (n.getValue() == null) {
					return true;
				}
			} else {
				if (n.getValue().equals(obj)) {
					return true;
				}
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int index = 0;
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (obj == null) {
				if (n.getValue() == null) {
					return index;
				}
			} else {
				if (n.getValue().equals(obj)) {
					return index;
				}
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		add(nodeCount, obj);
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		if (contains(obj)) {
			remove(indexOf(obj));
			return true;
		} else {
			return false;
		}
	}

	// Returns the i-th element.
	public E get(int i) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (indexOf(n.getValue()) == i) {
				return n.getValue();
			}
		}
		return null;
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, Object obj) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (indexOf(n.getValue()) == i) {
				E returned = n.getValue();
				n.setValue((E) obj);
				return returned;
			}
		}
		return null;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Object obj) {
		if (i > nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> tempAdd = new ListNode<E>((E) obj);
		if (i == 0) {
			tempAdd.setNext(head);
			head = tempAdd;
			if (nodeCount == 0) {
				tail = tempAdd;
			}
			nodeCount++;
			return;
		}
		int index = 0;
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (index == i - 1) {
				tempAdd.setNext(n.getNext());
				n.setNext(tempAdd);
				if (tempAdd.getNext() == null) {
					tail = tempAdd;
				}
				nodeCount++;
				return;
			}
			index++;
		}
	}

	public E remove(int i) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			E returned = head.getValue();
			head = head.getNext();
			nodeCount--;
			if (head == null) {
				tail = null;
			}
			return returned;
		}
		for (ListNode<E> n = head; n != null; n = n.getNext()) {
			if (indexOf(n.getValue()) == i - 1) {
				E returned = n.getNext().getValue();
				n.setNext(n.getNext().getNext());
				nodeCount--;
				if (n.getNext() == null) {
					tail = n;
				}
				return returned;
			}
		}
		return null;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("[");
		for (ListNode<E> n = head; n.getNext() != null; n = n.getNext()) {
			toReturn.append(n.getValue());
			toReturn.append(", ");
		}
		toReturn.append(tail.getValue());
		toReturn.append("]");
		return toReturn.toString();
	}


}
