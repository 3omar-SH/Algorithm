import java.util.Scanner;

public class Solution {
    public static void sol1(int n){
        int [] arr = {100 , 20 , 10 , 5 , 1};
        int res =0;
        for (int i = 0; i < arr.length; i++){
            res += n / arr[i];
            n %= arr[i];
        }
        System.out.println(res);
    }
    //Dynamic programming
    public static int sol2(int n){
        int [] denominationsDollars = {1 , 5 , 10 , 20 , 100};
        int [] dpArr = new int[n + 1];
        dpArr[0] = 0;
        for (int i= 1 ; i <= n ; i++){
            dpArr[i] = Integer.MAX_VALUE;
        }
        for (int d : denominationsDollars){
            for (int i = d; i <= n ; i++){
                if (dpArr[i-d] != Integer.MAX_VALUE){
                    dpArr[i] = Math.min(dpArr[i], dpArr[i-d] + 1);
                }
            }
        }
        return dpArr[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        sol1(n);
        System.out.println("sol2: "+sol2(n));
    }
}
