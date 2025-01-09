import java.util.Scanner;

public class Binomial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Binomial test = new Binomial();
        System.out.println(test.bin(n,k));
        System.out.println(test.bin3(n,k));
        System.out.println(test.bin2(n,k));
    }
    //dynamic programming
    int bin(int n , int k){
        int [][] b = new int[n+1][k+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= Math.min(i , k); j++){
                if (j == 0 || j == i){
                    b[i][j] = 1;
                }
                else{
                    b[i][j] = b[i-1][j-1] + b[i-1][j];
                }
            }
        }
        return b[n][k];
    }
    //recursion
    int bin2(int n , int k){
        if (k == 0 || n == k) return 1;
        else return bin2(n - 1, k-1) + bin2(n - 1, k );
    }
    //dynamic programming
    int bin3(int n , int k){
        int[] b = new int[n+1];
        int sOld , sNew;
        for (int i = 0; i <= n; i++){
            sOld = sNew = b[0];
            for (int j = 0; j <= Math.min(i , k); j++){
                if (j == 0 || j == i){
                    b[j]=1;
                }
                else{
                    sNew = b[j];
                    b[j] += sOld ;
                    sOld = sNew;
                }
            }
        }
        return b[k];
    }
}
