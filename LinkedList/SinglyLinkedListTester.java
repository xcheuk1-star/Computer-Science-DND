public class SinglyLinkedListTester {
    public static void main(String[] args) {
        Object[] values = new Object[5];
        values[0] = "one";
        values[1] = "two";
        values[2] = "three";
        values[3] = "four";
        values[4] = "five";
        SinglyLinkedList<String> waller = new SinglyLinkedList<String>(values);
        waller.toString();
    }
    
}
