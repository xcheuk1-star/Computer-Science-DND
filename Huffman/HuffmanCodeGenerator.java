import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCodeGenerator {
    private HashMap<Character, Integer> freqTable;
    private HashMap<Character, String> codeTable;
    private ArrayList<Character> chars;
    private HuffmanNode root;

    public HuffmanCodeGenerator(String frequencyFile) throws IOException {
        freqTable = new HashMap<>();
        chars = new ArrayList<>();
        codeTable = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(frequencyFile));
        int charAsInt;
        while ((charAsInt = br.read()) != -1) {
            char c = (char) charAsInt;
            if (freqTable.containsKey(c)) {
                freqTable.put(c, freqTable.get(c) + 1);
            } else {
                freqTable.put(c, 1);
                chars.add(c);
            }
        }
        br.close();

        char eof = (char) 26;
        if (freqTable.containsKey(eof)) {
            freqTable.put(eof, freqTable.get(eof) + 1);
        } else {
            freqTable.put(eof, 1);
            chars.add(eof);
        }

        buildTree();
        buildCodeTable(root, "");
    }

    public int getFrequency(char c) {
        if (freqTable.containsKey(c)) {
            return freqTable.get(c);
        }
        return 0;
    }

    public HuffmanNode buildTree() {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            pq.offer(new HuffmanNode(c, freqTable.get(c)));
        }

        while (pq.size() > 1) {
            HuffmanNode first = pq.poll();
            HuffmanNode second = pq.poll();
            HuffmanNode left;
            HuffmanNode right;

            if (first.getFrequency() <= second.getFrequency()) {
                left = first;
                right = second;
            } else {
                left = second;
                right = first;
            }
            HuffmanNode parent =
                    new HuffmanNode(left.getFrequency() + right.getFrequency(), left, right);
            pq.offer(parent);

        }
        root = pq.poll();
        return root;
    }

    public HuffmanNode getRoot() {
        return root;
    }

    private void buildCodeTable(HuffmanNode curr, String code) {
        if (curr == null) {
            return;
        }
        if (curr.isLeaf()) {
            codeTable.put(curr.getCharacter(), code);
            return;
        }

        buildCodeTable(curr.getLeft(), code + "0");
        buildCodeTable(curr.getRight(), code + "1");
    }

    public String getCode(char c) {
        if (codeTable.containsKey(c)) {
            return codeTable.get(c);
        }
        return "";
    }

    public void makeCodeFile(String codeFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(codeFile));
        for (int i = 0; i < 256; i++) {
            bw.write(getCode((char) i));
            bw.newLine();
        }
        bw.close();
    }
}


