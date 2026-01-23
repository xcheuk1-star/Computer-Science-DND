// Implements a BST with BinaryNode nodes
import java.util.ArrayList;
import java.util.List;

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
		return containsHelper(root, value);
	}

	public boolean containsHelper(BinaryNode<E> on, E value) {
		if (on == null) {
			return false;
		}
		if (on.getValue().equals(value)) {
			return true;
		}

		if (on.getValue().compareTo(value) > 0) {
			if (on.getLeft() == null) {
				return false;
			}
			return containsHelper(on.getLeft(), value);
		}
		if (on.getValue().compareTo(value) < 0) {
			if (on.getRight() == null) {
				return false;
			}
			return containsHelper(on.getRight(), value);
		}
		return false;
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(E value) {
		BinaryNode<E> toAdd = new BinaryNode<E>(value);
		if (root == null) {
			root = toAdd;
			return true;
		}
		if (this.contains(value)) {
			return false;
		} else {
			addHelper(root, toAdd);
			return true;
		}
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
		if (value == null) {
			return false;
		}

		BinaryNode<E> toRemove = findNode(root, value);
		if (toRemove == null) {
			return false;
		}
		removeNode(toRemove);
		return true;
	}

	public BinaryNode<E> findNode(BinaryNode<E> curr, E value) {
		if (curr == null) {
			return null;
		}

		if (value.compareTo(curr.getValue()) == 0) {
			return curr;
		}

		if (value.compareTo(curr.getValue()) < 0) {
			return findNode(curr.getLeft(), value);
		}

		if (value.compareTo(curr.getValue()) > 0) {
			return findNode(curr.getRight(), value);
		}

		return null;
	}

	public void removeNode(BinaryNode<E> node) {
		if (node.isLeaf()) {
			replace(node, null);
			return;
		}

		if (node.getLeft() == null) {
			replace(node, node.getRight());
			return;
		}

		if (node.getRight() == null) {
			replace(node, node.getLeft());
			return;
		}

		BinaryNode<E> next = minHelper(node.getRight());
		node.setValue(next.getValue());
		replace(next, next.getRight());
	}

	public void replace(BinaryNode<E> node, BinaryNode<E> newChild) {
		BinaryNode<E> p = node.getParent();
		if (newChild != null) {
			newChild.setParent(p);
		}
		if (p == null) {
			root = newChild;
			return;
		}
		if (p.getLeft() == node) {
			p.setLeft(newChild);
		} else {
			p.setRight(newChild);
		}
	}

	// Returns the minimum in the tree
	public E min() {
		return minHelper(root).getValue();
	}

	public BinaryNode<E> minHelper(BinaryNode<E> curr) {
		if (curr.getLeft() == null) {
			return curr;
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
		return maxHelper(curr.getRight());
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
