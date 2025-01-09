package dp_greedy.src;

public class HuffmanNode  implements Comparable<HuffmanNode>{
    char symbol;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;
    public HuffmanNode(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.symbol = '\0';
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    public int compareTo(HuffmanNode o) {
        return frequency - o.frequency;
    }
}
