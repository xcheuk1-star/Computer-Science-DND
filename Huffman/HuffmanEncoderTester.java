import java.io.IOException;

public class HuffmanEncoderTester {
    public static void main(String[] args) throws IOException {
        HuffmanEncoder e = new HuffmanEncoder("result.txt");
        e.encodeFileToHuffmanCodes("banana.txt", "encoded.txt");

    }
}
