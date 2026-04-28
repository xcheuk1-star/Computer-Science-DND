public class HuffmanNode implements Comparable {
    private char character;
    private int frequency;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the character
     */
    public char getCharacter() {
        return character;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @return the left
     */
    public HuffmanNode getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public HuffmanNode getRight() {
        return right;
    }


    public boolean isLeaf() {
        if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object other) {
        HuffmanNode otherNode = (HuffmanNode) other;
        return this.frequency - otherNode.frequency;
    }

}
