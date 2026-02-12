public class HeapTester {
    public static void main(String[] args) {
        HeapPQ<Integer> waller = new HeapPQ<>();
        waller.add(6);
        waller.add(8);
        waller.add(7);
        waller.add(10);
        waller.add(9);
        waller.add(11);
        waller.add(4);
        System.out.println(waller.toString());
        waller.removeMin();
        System.out.println(waller.toString());
    }
}
