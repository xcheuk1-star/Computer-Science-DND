public class Tester {
    public static void main(String[] args) {
        // ListNode one = new ListNode("One");
        // ListNode two = new ListNode("Two");
        // ListNode three = new ListNode("Three");
        // one.setNext(two);
        // two.setNext(three);

        // Recursion.printListInReverse(one);

        // System.out.println(Recursion.countNonConsecutiveSubsets(5));
        // System.out.println(Recursion.countWaysToJumpUpStairs(5));
        // Recursion.printSubsets("abc");
        // Recursion.printPermutations("abc");
        int[] ints = {2, 5, 96, 34, 43, 42, 1, 99, 35};
        Recursion.mergeSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }
        // Recursion.solveHanoi(5);
        // int[] times = {2, 6, 7, 20, 21, 40, 41, 43, 45, 47, 51, 53, 62, 63, 64};
        // int[] points = {1000000, 4, 7, 300, 8, 20, 251, 23, 21, 1220, 8, 9, 14, 81, 82};

        // System.out.println(Recursion.scavHunt(times, points));
    }
}
