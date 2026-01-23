public class MyStackTester {
    public static void main(String[] args) {
        MyStack<String> s = new MyStack<String>();
        System.out.println(s.isEmpty());
        s.push("Derp");
        String str = s.peek();
        System.out.println(str);
        System.out.println(s.isEmpty());
        s.pop();
        System.out.println(s.isEmpty());
    }
}
