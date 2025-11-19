public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		if (head.getNext() == null) {
			System.out.println(head.getValue().toString());
		} else {
			printListInReverse(head.getNext());
			System.out.println(head.getValue().toString());
		}

	}


	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r > grid.length - 1 || r < 0 || c > grid[0].length - 1 || c < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (grid[r][c] == "infected" || grid[r][c] == "vaccinated") {
			return;
		} else {
			grid[r][c] = "infected";
		}
		if (r != grid.length - 1) {
			infect(grid, r + 1, c);
		}
		if (r != 0) {
			infect(grid, r - 1, c);
		}
		if (c != grid[0].length - 1) {
			infect(grid, r, c + 1);
		}
		if (c != 0) {
			infect(grid, r, c - 1);
		}
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		if (n == 0) {
			return (long) 1;
		}
		if (n == 1) {
			return (long) 2;
		} else {
			return countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);
		}

	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		// if (n == 0) {
		// return 0;
		// }
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2)
				+ countWaysToJumpUpStairs(n - 3);
	}

	// Everything above this line does NOT require a recursive helper method
	// ----------------------------------
	// Everything below this line requires a recursive helper method
	// Any recursive helper method you write MUST have a comment describing:
	// 1) what the helper method does/returns
	// 2) your description must include role of each parameter in the helper method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice

	public static void subsetsHelper(String str, int index, String current) {
		if (index == str.length()) {
			System.out.println(current);
			return;
		}
		subsetsHelper(str, index + 1, current);
		subsetsHelper(str, index + 1, current + str.charAt(index));
	}

	public static void printSubsets(String str) {
		subsetsHelper(str, 0, "");
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice

	public static void permutationsHelper(String current, String left) {
		if (left.length() == 0) {
			System.out.println(current);
			return;
		}

		for (int i = 0; i < left.length(); i++) {
			char ch = left.charAt(i);
			String newCurrent = current + ch;
			String newLeft = left.substring(0, i) + left.substring(i + 1);
			permutationsHelper(newCurrent, newLeft);
		}
	}

	public static void printPermutations(String str) {
		permutationsHelper("", str);
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		if (ints == null) {
			return;
		}
		int[] sorted = sort1(ints);
		for (int i = 0; i < ints.length; i++) {
			ints[i] = sorted[i];
		}
	}

	public static int[] sort1(int[] ints) {
		if (ints.length <= 1) {
			return ints;
		}

		int[] firstHalf = new int[ints.length / 2];
		for (int i = 0; i < ints.length / 2; i++) {
			firstHalf[i] = ints[i];
		}
		int[] secondHalf = new int[ints.length - ints.length / 2];
		for (int i = ints.length / 2; i < ints.length; i++) {
			secondHalf[i - ints.length / 2] = ints[i];
		}
		int[] left = sort1(firstHalf);
		int[] right = sort1(secondHalf);

		return merge(left, right);
	}

	public static int[] merge(int[] p1, int[] p2) {
		int[] merged = new int[p1.length + p2.length];
		int i = 0;
		int j = 0;
		int f = 0;
		while (i < p1.length && j < p2.length) {
			if (p1[i] < p2[j]) {
				merged[f] = p1[i];
				i++;
			} else {
				merged[f] = p2[j];
				j++;
			}
			f++;
		}
		while (i < p1.length) {
			merged[f] = p1[i];
			i++;
			f++;
		}
		while (j < p2.length) {
			merged[f] = p2[j];
			j++;
			f++;
		}
		return merged;
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {
		if (ints == null) {
			return;
		}
		sort2(ints, 0, ints.length - 1);
	}

	public static void sort2(int[] ints, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = split(ints, left, right);
		sort2(ints, left, index - 1);
		sort2(ints, index, right);

	}

	public static int split(int[] ints, int left, int right) {
		int pivot = ints[(left + right) / 2];
		while (left <= right) {
			while (ints[left] < pivot) {
				left++;
			}
			while (ints[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = ints[left];
				ints[left] = ints[right];
				ints[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}


	// public static int[] quick(int start, int end, int[] ints) {
	// if (start > end);
	// }

	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.

	public static void moveDisk(int current, int destination) {
		System.out.println(current + " -> " + destination);
	}

	public static void solveTower(int disks, int start, int end, int free) {
		if (disks == 2) {
			moveDisk(start, free);
			moveDisk(start, end);
			moveDisk(free, end);
		} else {
			solveTower(disks - 1, start, free, end);
			moveDisk(start, end);
			solveTower(disks - 1, free, end, start);
		}
	}

	public static void solveHanoi(int startingDisks) {
		solveTower(startingDisks, 0, 2, 1);
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.

	public static int findMaxReward(int[] times, int index, int[] points) {
		if (index == times.length - 1) {
			return points[index];
		}
		if (findNextCompatible(times, index, points) == -1) {
			return points[index];
		}
		int takeIndex = points[index]
				+ findMaxReward(times, findNextCompatible(times, index, points), points);
		int takeNext = findMaxReward(times, index + 1, points);
		if (takeIndex > takeNext) {
			return takeIndex;
		} else {
			return takeNext;
		}
		// take points at index + max reward of the next compatible
		// or go to the next one and get max reward
		// find the bigger one and do it
	}

	public static int findNextCompatible(int[] times, int index, int[] points) {
		int current = times[index];
		for (int i = index; i < times.length; i++) {
			if (times[i] > current + 4) {
				return i;
			}
		}
		return -1;
	}

	public static int scavHunt(int[] times, int[] points) {
		return findMaxReward(times, 0, points);
	}

}
