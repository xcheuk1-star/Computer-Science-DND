import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.Stack;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make
// stacks and queues


public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	// You may find it VERY helpful to write this helper method. Or not!
	private boolean validPoint(int row, int col) {
		if (row < 0 || row >= numRows) {
			return false;
		}
		if (col < 0 || col >= numCols) {
			return false;
		}
		if (cookieGrid[row][col] == -1) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies. Returns the maximum number of
	 * cookies attainable.
	 */
	public int recursiveCookies() {
		return recursiveCookies(0, 0);
	}

	// Returns the maximum number of cookies edible starting from (and including)
	// cookieGrid[row][col]
	public int recursiveCookies(int row, int col) {
		if (validPoint(row, col) == false) {
			throw new IndexOutOfBoundsException();
		}
		if (row == numRows - 1 && col == numCols - 1) {
			return cookieGrid[row][col];
		}
		int right = 0;
		int down = 0;
		if (validPoint(row + 1, col)) {
			down = down + cookieGrid[row][col] + recursiveCookies(row + 1, col);
		}
		if (validPoint(row, col + 1)) {
			right = right + cookieGrid[row][col] + recursiveCookies(row, col + 1);
		}
		// System.out.println(Math.max(down, right) + " row: " + row + " col: " + col);
		return Math.max(down, right);
	}


	/*
	 * Calculate which route grants the most cookies using a QUEUE. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int queueCookies() {
		// CODE THIS
		return 0;
	}


	/*
	 * Calculate which route grants the most cookies using a stack. Returns the maximum number of
	 * cookies attainable.
	 */
	/* From any given position, always add the path right before adding the path down */
	public int stackCookies() {
		int total = 0;
		Stack<OrphanScout> jail = new Stack<OrphanScout>();
		OrphanScout waller = new OrphanScout(0, 0, cookieGrid[0][0]);
		return 0;
	}

}
