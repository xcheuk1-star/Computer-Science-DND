public class ArithmeticTester {
    public static void main(String[] args) {
        String waller = "-100 + (2 * 3 - 4)";
        System.out.println(waller);
        System.out.println(Arithmetic.convertClassicToStout(waller));
        String converted = Arithmetic.convertClassicToStout(waller);
        System.out.println(Arithmetic.evaluateStout(converted));
        System.out.println(Arithmetic.evaluate(waller));
    }
}
