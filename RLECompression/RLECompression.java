import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RLECompression {

    // Creates a compressed version with fileName + ".rle.bw"
    public static void compress(String fileName) throws IOException {
        bwTransform(fileName);
        encode(fileName + ".bw");
    }

    // Decompresses a .rle.bw file
    public static void decompress(String fileName) throws IOException {
        decode(fileName);
        invertBWTransform(fileName.substring(0, fileName.length() - 4));
    }

    // Encodes the contents of a file using the RLE compression scheme:
    // single characters are left alone, and runs of 2+ characters are encoded as
    // that letter twice, followed by the length of the run, cast as a char
    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".rle");

        char previousChar = (char) br.read();
        int count = 1;
        while (br.ready()) {
            char c = (char) br.read();
            if (c == previousChar) {
                count++;
            } else {
                if (count > 1) {
                    pw.write(previousChar);
                    pw.write(previousChar);
                    pw.write((char) (count + 48));
                    count = 1;
                } else {
                    pw.write(previousChar);
                }
            }
            previousChar = c;

        }

        if (count > 1) {
            pw.write(previousChar);
            pw.write(previousChar);
            pw.write((char) (count + 48));
            count = 1;
        } else {
            pw.write(previousChar);
        }
        br.close();
        pw.close();
    }

    // Decodes the above scheme
    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 4));

        char previousChar = (char) br.read();

        while (br.ready()) {
            char c = (char) br.read();
            if (previousChar == c) {
                int count = br.read() - 48;
                for (int i = 0; i < count; i++) {
                    pw.write(previousChar);
                }

                if (br.ready()) {
                    previousChar = (char) br.read();
                } else {
                    previousChar = 0;
                }
            } else {
                pw.write(previousChar);
                previousChar = c;
            }
        }
        if (previousChar != 0) {
            pw.write(previousChar);
        }

        br.close();
        pw.close();
    }

    public static void bwTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Add a null character at the beginning, as a
        // "beginning of file" character
        StringBuilder originalText = new StringBuilder("" + '\0');

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] rotations = new String[originalText.length()];
        rotations[0] = originalText.toString();
        String word = originalText.toString();
        for (int i = 1; i < originalText.length(); i++) {
            word = word.substring(word.length() - 1) + word.substring(0, word.length() - 1);
            rotations[i] = word;
        }
        Arrays.sort(rotations);
        StringBuilder transformed = new StringBuilder();
        for (int i = 0; i < rotations.length; i++) {
            transformed.append(rotations[i].charAt(word.length() - 1));
        }
        PrintWriter pw = new PrintWriter(fileName + ".bw");
        pw.write(transformed.toString());
        pw.close();
    }

    public static void invertBWTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] reconstructions = new String[originalText.length()];
        for (int i = 0; i < reconstructions.length; i++) {
            reconstructions[i] = "" + originalText.charAt(i);
        }
        Arrays.sort(reconstructions);
        for (int i = 0; i < originalText.toString().length() - 1; i++) {
            for (int j = 0; j < reconstructions.length; j++) {
                reconstructions[j] = "" + originalText.charAt(j) + reconstructions[j];
            }
            Arrays.sort(reconstructions);
        }
        String toWrite = "";
        for (int j = 0; j < reconstructions.length; j++) {
            if (reconstructions[j].charAt(0) == '\0') {
                toWrite = reconstructions[j].substring(1);
            }
        }
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 3));
        pw.write(toWrite);
        pw.close();
    }
}
