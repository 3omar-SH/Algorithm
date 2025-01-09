package dp_greedy.src;

import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        char[] symbols = {'a' , 'b' , 'c' , 'd' , 'e' , 'f' };
        int[] frequencies = {5, 9 , 12 , 13 , 16 , 45};
        HuffmanNode root = buildHuffmanTree1(symbols , frequencies);
        String[] codes = new String[256];
        generateCodes1(root , "" , codes);
        for (int i = 0; i < symbols.length; i++) {
            System.out.println(symbols[i] + ": " + codes[symbols[i]]);
        }
    }
    // build huffman tree
    public static HuffmanNode buildHuffmanTree1(char[] symbols , int[] frequencies) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            pq.add(new HuffmanNode(symbols[i] , frequencies[i]));
        }
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode newNode = new HuffmanNode(left.frequency + right.frequency, left , right);
            pq.add(newNode);
        }
        return pq.poll();
    }
    // for generate code huffman
    public static void generateCodes1(HuffmanNode root , String code , String[] codes) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            codes[root.symbol] = code;
        }
        generateCodes1(root.left , code+"0" , codes);
        generateCodes1(root.right , code+"1" , codes);
    }
}
