
public class DoublyLinkedListTester {
    public static void main(String[] args) {
        Nucleotide[] values = new Nucleotide[6];
        values[0] = Nucleotide.A;
        values[1] = Nucleotide.A;
        values[2] = Nucleotide.T;
        values[3] = Nucleotide.G;
        values[4] = Nucleotide.A;
        values[5] = Nucleotide.C;
        DoublyLinkedList waller = new DoublyLinkedList(values);;
        System.out.println(waller.toString());
        waller.add(0, Nucleotide.A);
        System.out.println(waller.toString());
    }
}
