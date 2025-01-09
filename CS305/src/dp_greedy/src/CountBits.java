package dp_greedy.src;

public class CountBits {
    public static void main(String[] args){
        int[] res = countBits(5);
        for (int i : res)
            System.out.print(i + " ");
    }
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i)
                offset *= 2;
            res[i] = res[i - offset] + 1;
        }
        return res;
    }
}
