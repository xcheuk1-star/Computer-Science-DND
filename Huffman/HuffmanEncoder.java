import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HuffmanEncoder {
    private HashMap<Integer, String> codeTable;

    public HuffmanEncoder(String codeFile) throws IOException {
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

    public void encodeFileToHuffmanCodes(String fileToCompress, String encodedFile)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileToCompress));
        BufferedWriter bw = new BufferedWriter(new FileWriter(encodedFile));
        int charAsInt;
        String toWrite = "";
        while ((charAsInt = br.read()) != -1) {
            toWrite = toWrite + codeTable.get(charAsInt);
        }

        int numZeros = 8 - toWrite.length() % 8;
        for (int i = 0; i < numZeros; i++) {
            toWrite = toWrite + "0";
        }
        bw.write(toWrite);

        br.close();
        bw.close();
    }

}
