public class DoublyLinkedListTester {
    public static void main(String[] args) {
        DoublyLinkedList waller = new DoublyLinkedList();
        waller.add(Nucleotide.A);
        waller.add(Nucleotide.C);
        waller.add(Nucleotide.G);
        waller.add(Nucleotide.T);
        System.out.println(waller.toString());
    }
}
