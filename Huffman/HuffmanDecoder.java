import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HuffmanDecoder {
    private HashMap<Integer, String> codeTable;

    public HuffmanDecoder(String codeFile) throws IOException {
        codeTable = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(codeFile));
        int i = 0;
        String line = "";
        while ((line = br.readLine()) != null) {
            codeTable.put(i, line);
            i++;
        }

        br.close();
    }

    public boolean isCode(String binary) {
        for (int i = 0; i < codeTable.size(); i++) {
            if (binary.equals(codeTable.get(i))) {
                return true;
            }
        }
        return false;
    }

    public char decodeChar(String binary) {
        for (int i = 0; i < codeTable.size(); i++) {
            if (binary.equals(codeTable.get(i))) {
                return ((char) i);
            }
        }
        return ' ';
    }

    public void decodeFileFromHuffmanCodes(String encodedFile, String decodedFile)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(encodedFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(decodedFile));
        String encoded = "";
        int num;
        while ((num = br.read()) != -1) {
            encoded = encoded + (char) num;
        }
        System.out.println(encoded);
        String s = "";
        for (int i = 0; i < encoded.length(); i++) {
            s = s + encoded.charAt(i);
            if (isCode(s)) {
                if (decodeChar(s) == (char) 26) {
                    return;
                } else {
                    bw.write(decodeChar(s));
                    s = "";
                }
            }
        }
        br.close();
        bw.close();
    }

}
