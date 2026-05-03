
import java.io.IOException;

public class HuffmanDecoderTester {
    public static void main(String[] args) throws IOException {
        HuffmanDecoder d = new HuffmanDecoder("result.txt");
        System.out.println(d.decodeChar("00"));
        d.decodeFileFromHuffmanCodes("encoded.txt", "decoded.txt");
    }
}
