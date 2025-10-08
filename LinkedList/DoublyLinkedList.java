
public class DoublyLinkedList {
	// Implements a circular doubly-linked list.

	private final ListNode2<Nucleotide> SENTINEL = new ListNode2<Nucleotide>(null);
	private int nodeCount;

	// Constructor: creates an empty list
	public DoublyLinkedList() {
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		nodeCount = 0;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public DoublyLinkedList(Nucleotide[] values) {
		nodeCount = 0;
		SENTINEL.setNext(SENTINEL);
		SENTINEL.setPrevious(SENTINEL);
		for (int i = 0; i < values.length; i++) {
			add(values[i]);
		}
	}

	public ListNode2<Nucleotide> getSentinel() {
		return SENTINEL;
	}

	public ListNode2<Nucleotide> getHead() {
		return SENTINEL.getNext();
	}

	public ListNode2<Nucleotide> getTail() {
		return SENTINEL.getPrevious();
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
	public boolean contains(Nucleotide obj) {
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (n.getValue().equals(obj)) {
				return true;
			}
		}
		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Nucleotide obj) {
		int index = 0;
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (n.getValue().equals(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(Nucleotide obj) {
		ListNode2<Nucleotide> added = new ListNode2<Nucleotide>(obj);
		ListNode2<Nucleotide> last = this.SENTINEL.getPrevious();
		if (nodeCount == 0) {
			SENTINEL.setNext(added);
			added.setNext(SENTINEL);
			SENTINEL.setPrevious(added);
			added.setPrevious(SENTINEL);
		}
		last.setNext(added);
		added.setNext(SENTINEL);
		added.setPrevious(last);
		SENTINEL.setPrevious(added);
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Nucleotide obj) {
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (n.getValue().equals(obj)) {
				n.getPrevious().setNext(n.getNext());
				n.getNext().setPrevious(n.getPrevious());
				nodeCount--;
				return true;
			}
		}
		return false;
	}

	// Returns the i-th element.
	public Nucleotide get(int i) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (nodeCount == 0) {
			System.out.println("list is empty you can't get anything");
		}
		ListNode2<Nucleotide> n = SENTINEL.getNext();
		for (int j = 0; j <= i; j++) {
			if (j == i) {
				return n.getValue();
			}
			n = n.getNext();
		}
		return null;
	}

	// Replaces the i-th element with obj and returns the old value.
	public Nucleotide set(int i, Nucleotide obj) {
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (nodeCount == 0) {
			System.out.println("list is empty you cant set anything");
		}
		ListNode2<Nucleotide> n = SENTINEL.getNext();
		for (int j = 0; j <= i; j++) {
			if (j == i) {
				Nucleotide returned = n.getValue();
				n.setValue(obj);
				return returned;
			}
			n = n.getNext();
		}
		return null;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, Nucleotide obj) {
		if (i > nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode2<Nucleotide> added = new ListNode2<Nucleotide>(obj);
		ListNode2<Nucleotide> n = SENTINEL.getNext();
		if (i == 0) {
			ListNode2<Nucleotide> newNext = SENTINEL.getNext();
			SENTINEL.getNext().setPrevious(added);
			SENTINEL.setNext(added);
			SENTINEL.getNext().setPrevious(SENTINEL);
			SENTINEL.getNext().setNext(newNext);

		}
		for (int j = 0; j < i; j++) {
			if (j == i - 1) {
				ListNode2<Nucleotide> newNext = n.getNext();
				n.getNext().setPrevious(added);
				n.setNext(added);
				n.getNext().setPrevious(n);
				n.getNext().setNext(newNext);
			}
			n = n.getNext();
		}
		nodeCount++;
	}



	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Nucleotide remove(int i) {
		if (nodeCount == 0) {
			System.out.println("list is empty");
		}
		if (i >= nodeCount || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (i == 0) {
			SENTINEL.setNext(SENTINEL.getNext().getNext());
			SENTINEL.getNext().getNext().setPrevious(SENTINEL);
			nodeCount--;
			return SENTINEL.getNext().getValue();
		}
		int index = 0;
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (index == i) {
				Nucleotide returned = n.getValue();
				n.getPrevious().setNext(n.getNext());
				n.getNext().setPrevious(n.getPrevious());
				nodeCount--;
				return returned;
			}
			index++;
		}
		return null;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder returned = new StringBuilder();
		returned.append("[");
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL.getPrevious(); n =
				n.getNext()) {
			returned.append(n.getValue());
			returned.append(", ");
		}
		returned.append(SENTINEL.getPrevious().getValue());
		returned.append("]");
		return returned.toString();

	}

	// Like question 7 on the SinglyLinkedList test:
	// Add a "segment" (another list) onto the end of this list
	public void addSegmentToEnd(DoublyLinkedList seg) {
		ListNode2<Nucleotide> ogLast = SENTINEL.getPrevious();
		ListNode2<Nucleotide> addedFirst = seg.getSentinel().getNext();
		ListNode2<Nucleotide> addedLast = seg.getSentinel().getPrevious();
		ogLast.setNext(addedFirst);
		ogLast.getNext().setPrevious(ogLast);
		addedLast.setNext(SENTINEL);
		SENTINEL.setPrevious(addedLast);
		nodeCount = nodeCount + seg.size();
	}

	// Like question 8 on the SinglyLinkedList test:
	// You are to remove the next 16 nodes from the list, after the node nodeBefore.
	// (on the test these nodes were assumed to contain CCCCCCCCGGGGGGGG, but here
	// you do not need to assume or check for that)
	public void removeCCCCCCCCGGGGGGGG(ListNode2<Nucleotide> nodeBefore) {
		if (contains(nodeBefore.getValue()) == (false)) {
			System.out.println("not in the list");
		}
		if (nodeCount < 17) {
			System.out.println("list too short");
		}
		ListNode2<Nucleotide> n = nodeBefore;
		for (int i = 0; i <= 17; i++) {
			if (i == 17) {
				nodeBefore.setNext(n);
				n.setPrevious(nodeBefore);
			}
			n = n.getNext();
		}
		nodeCount = nodeCount - 16;
	}

	// Like question 9 on the SinglyLinkedList test:
	// You are to find and delete the first instance of seg in the list.
	// If seg is not in the list, return false, otherwise return true.
	public boolean deleteSegment(DoublyLinkedList seg) {
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (n.getValue().equals(seg.getHead().getValue())) {
				ListNode2<Nucleotide> current = n;
				ListNode2<Nucleotide> m = seg.getHead();
				ListNode2<Nucleotide> ogStart = n.getPrevious();
				int count = 0;
				while (current != SENTINEL && count < seg.size()
						&& n.getValue().equals(m.getValue())) {
					n = n.getNext();
					m = m.getNext();
					count++;
				}
				if (count == seg.size()) {
					ogStart.setNext(n);
					n.setPrevious(ogStart);
					nodeCount = nodeCount - seg.size();
					return true;
				}
			}
		}
		return false;
	}

	// Like question 10 on the SinglyLinkedList test:
	// Delete the last three nodes in the list
	// If there are not enough nodes, return false
	public boolean deleteLastThree() {
		if (nodeCount < 3) {
			return false;
		}
		ListNode2<Nucleotide> n = SENTINEL.getPrevious();
		for (int i = 0; i < 3; i++) {
			n = n.getPrevious();
		}
		n.setNext(SENTINEL);
		SENTINEL.setPrevious(n);
		nodeCount = nodeCount - 3;
		return true;
	}

	// Like question 11 on the SinglyLinkedList test:
	// Replaces every node containing "A" with three nodes containing "T" "A" "C"
	public void replaceEveryAWithTAC() {
		for (ListNode2<Nucleotide> n = SENTINEL.getNext(); n != SENTINEL; n = n.getNext()) {
			if (n.getValue().equals(Nucleotide.A)) {
				ListNode2<Nucleotide> T = new ListNode2<Nucleotide>(Nucleotide.T);
				ListNode2<Nucleotide> C = new ListNode2<Nucleotide>(Nucleotide.C);
				n.getPrevious().setNext(T);
				T.setPrevious(n.getPrevious());
				n.setPrevious(T);
				T.setNext(n);
				n.getNext().setPrevious(C);
				C.setNext(n.getNext());
				n.setNext(C);
				C.setPrevious(n);
				nodeCount = nodeCount + 2;
			}
		}
	}

}
