public class HashFunction {
    public static long hashFn(String name) {
        char[] arr = name.toCharArray();
        long num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num = num * (long) arr[i];
            } else {
                num = num + (long) arr[i];
            }
        }
        return Math.abs(num % 500);
    }
}
