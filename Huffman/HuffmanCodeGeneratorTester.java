import java.io.IOException;

public class HuffmanCodeGeneratorTester {
    public static void main(String[] args) throws IOException {
        HuffmanCodeGenerator h = new HuffmanCodeGenerator("banana.txt");
        System.out.println(h.getCode('a'));
        h.makeCodeFile("result.txt");
    }
}
