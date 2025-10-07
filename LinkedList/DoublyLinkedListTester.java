public class DoublyLinkedListTester {
    public static void main(String[] args) {
        DoublyLinkedList waller = new DoublyLinkedList();
        waller.add(Nucleotide.A);
        waller.add(Nucleotide.C);
        waller.add(Nucleotide.G);
        waller.add(Nucleotide.T);
        System.out.println(waller.toString());
        DoublyLinkedList add = new DoublyLinkedList();
        add.add(Nucleotide.A);
        add.add(Nucleotide.G);
        System.out.println(add);
        waller.addSegmentToEnd(add);
        System.out.println(waller.toString());
    }
}
