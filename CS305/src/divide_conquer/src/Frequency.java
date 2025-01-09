package divide_conquer.src;

public class Frequency {
    static int[] array = new int['z' + 1];

    public static void main(String[] args) {
        String word = "DivideAndConquer";
        word = word.toLowerCase();
        Freq(word, 0, word.length() - 1);
        for (char i = 'a'; i <= 'z'; i++) {
            if (array[i] > 0) {
                System.out.println(i+ " : " + array[i]);
            }
        }
    }

    public static void Freq(String word, int l, int r) {
        if (l == r) {
            array[word.charAt(l)]++;
            return;
        }
        int mid = l + (r - l) / 2;
        Freq(word, l, mid);
        Freq(word, mid + 1, r);
    }
}
