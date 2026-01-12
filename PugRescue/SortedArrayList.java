public class SortedArrayList<E extends Comparable<E>> extends MyArrayList<E> {


	@Override
	public boolean contains(E obj) {
		if (binarySearch(internalArray, internalArray[internalArray.length / 2]) == -1) {
			return false;
		} else {
			return true;
		}
	}

	public int binarySearch(E[] arr, E key) {
		return binarySearchRecursiveHelper(arr, key, 0, arr.length - 1);
	}

	/**
	 * Implements the binary search algorithm to find and return the index of a given element in a
	 * sorted array if it is between low and high, or -1 if it is not found between low and high.
	 */
	public int binarySearchRecursiveHelper(E[] arr, E key, int low, int high) {
		if (low > high) {
			return -1; // element not found
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid].compareTo(key) > 0) {
			return binarySearchRecursiveHelper(arr, key, low, mid - 1);
		} else {
			return binarySearchRecursiveHelper(arr, key, mid + 1, high);
		}
	}

	// May not contain more than one of the same object
	@Override
	public boolean add(E obj) {
		if (contains(obj)) {
			return false;
		} else {
			for (int i = 0; i < internalArray.length; i++) {
				if (obj.compareTo(internalArray[i]) > 0) {
					E temp = internalArray[i - 1];
					set(i - 1, obj);
					set(i, temp);
					for (int j = i; j < internalArray.length; j++) {
						set(j + 1, internalArray[j]);
					}
					return true;
				}
			}
			return false;
		}
	}


	@Override
	public boolean remove(E obj) {
		if (contains(obj)) {
			this.remove(obj);
			return true;
		} else {
			return false;
		}
	}

	public E min() {
		return internalArray[0];
	}

	public E max() {
		return internalArray[internalArray.length - 1];
	}
}
