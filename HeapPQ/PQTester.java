import java.util.PriorityQueue;
import java.util.Random;

public class PQTester {
    public static void main(String[] args) {
        HeapPQ<Integer> mine = new HeapPQ<>();
        PriorityQueue<Integer> javaPQ = new PriorityQueue<>();
        Random r = new Random(0);

        for (int t = 0; t < 20000; t++) {
            if (javaPQ.isEmpty() || r.nextInt(3) != 0) {
                int v = r.nextInt(100);
                mine.add(v);
                javaPQ.add(v);
            } else {
                int a = mine.removeMin();
                int b = javaPQ.remove();
                if (a != b) {
                    throw new AssertionError("Mismatch at t=" + t + " mine=" + a + " java=" + b);
                }
            }
            if (!javaPQ.isEmpty()) {
                int a = mine.peek();
                int b = javaPQ.peek();
                if (a != b) {
                    throw new AssertionError("Peek mismatch at t=" + t + " mine=" + a + " java=" + b);
                }
            }
        }
        System.out.println("All good");
    }
}
