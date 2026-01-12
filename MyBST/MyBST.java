// Implements a BST with BinaryNode nodes

public class MyBST<E extends Comparable<E>> {

	private BinaryNode<E> root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST() {
		root = null;
	}

	public BinaryNode<E> getRoot() {
		return root;
	}

	public int getHeight() {
		return root.getHeight();
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(E value) {
		return toString().contains(value.toString());
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		BinaryNode<E> toAdd = new BinaryNode<E>(value);
		if (root == null) {
			root = toAdd;
		}
		if (this.contains(value)) {
			return false;
		}
		addHelper(root, toAdd);
		return true;
	}

	public void addHelper(BinaryNode<E> curr, BinaryNode<E> toAdd) {
		if (toAdd.getValue().compareTo(curr.getValue()) > 0) {
			if (curr.hasRight()) {
				curr = curr.getRight();
				addHelper(curr, toAdd);
			} else {
				curr.setRight(toAdd);
				curr.getRight().setParent(curr);
			}
		}
		if (toAdd.getValue().compareTo(curr.getValue()) < 0) {
			if (curr.hasLeft()) {
				curr = curr.getLeft();
				addHelper(curr, toAdd);
			} else {
				curr.setLeft(toAdd);
				curr.getLeft().setParent(curr);
			}
		}
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	// If removing a node with two children: replace it with the
	// largest node in the right subtree
	public boolean remove(E value) {
		return false;
	}

	public boolean removeHelper(BinaryNode<E> curr, E value) {
		BinaryNode<E> toRemove = new BinaryNode<E>(value);
		if (curr.isLeaf()) {
			if (isRight()) {

			}
		}
	}

	public boolean isRight(BinaryNode<E> on) {
		if (on.getValue().compareTo(on.getParent().getValue()) > 0) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the minimum in the tree
	public E min() {
		return minHelper(root);
	}

	public E minHelper(BinaryNode<E> curr) {
		if (curr.getLeft() == null) {
			return curr.getValue();
		}
		return minHelper(curr.getLeft());
	}

	// Returns the maximum in the tree.
	public E max() {
		return maxHelper(root);
	}

	public E maxHelper(BinaryNode<E> curr) {
		if (curr.getRight() == null) {
			return curr.getValue();
		}
		return minHelper(curr.getRight());
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. [Apple, Cranberry, Durian, Mango]
	public String toString() {
		return ("[" + toStringHelper(root).toString().substring(0,
				toStringHelper(root).toString().length() - 2) + "]");
	}

	public StringBuilder toStringHelper(BinaryNode<E> on) {
		StringBuilder builder = new StringBuilder("");
		if (on == null) {
			return builder;
		}
		builder.append(toStringHelper(on.getLeft()));
		builder.append(on);
		builder.append(", " + toStringHelper(on.getRight()));
		return builder;
	}


}
