package divide_conquer.src;

import java.util.Arrays;

public class LongestString {
    public static void main(String[] args) {
        String[] s = {"omar", "malak", "khalid", "ali", "yosef" };
        System.out.println(solve(s, 0, s.length - 1));
        System.out.println(solve2(s));
    }

    public static String solve(String[] s, int l, int r) {
        if (l == r)
            return s[l];
        int mid = (l + r) / 2;
        String MaxL = solve(s, l, mid);
        String MaxR = solve(s, mid + 1, r);
        return MaxL.length() > MaxR.length() ? MaxL : MaxR;
    }
    public static String solve2(String[] s) {
        if (s.length == 1)
            return s[0];
        int mid = s.length / 2;
        String[] left = Arrays.copyOfRange(s , 0, mid);
        String[] right = Arrays.copyOfRange(s , mid, s.length);
        String MaxL = solve2(left);
        String MaxR = solve2(right);
        return MaxL.length() > MaxR.length() ? MaxL : MaxR;
    }
}
