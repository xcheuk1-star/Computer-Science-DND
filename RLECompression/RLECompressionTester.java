import java.io.IOException;

public class RLECompressionTester {
    public static void main(String[] args) throws IOException {
        RLECompression.encode("encode.txt");
        RLECompression.decode("decode.txt");
        RLECompression.bwTransform("bwTransform.txt");
        RLECompression.invertBWTransform("invertBWTransform.txt");
    }
}
