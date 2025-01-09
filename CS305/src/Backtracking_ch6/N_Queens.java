package Backtracking_ch6;

public class N_Queens {
    static int [] col;
    static int n;
    public static void queens(int i){
        // تجربه جميع الحلول
        if (promising(i)) {
            if (i == n) {    // لو كله اتحط اطبع
                for (int j = 1; j <= n; j++)
                    System.out.print(col[j] + " ");
                System.out.println();
            } else {
                for (int j = 1; j <= n; j++) {
                    col[i + 1] = j;
                    queens(i + 1);
                }
            }
        }
    }
    // تتحقق من عدم وجود تهديد من ملكه اخرى
    public static boolean promising(int i){
        int k = 1;
        boolean sw = true;
        while (sw && k < i) {
            if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k) {
                sw = false;
            }
            k++;
        }
        return sw;
    }
    public static void main(String[] args) {
        n = 4;
        col = new int[n + 1];
        queens(0);
    }
}
