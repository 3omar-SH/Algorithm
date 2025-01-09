import java.util.Scanner;

public class ClimbStairs {
    static int[] arr;
    //recursion
    private static int climbStairs1(int n) {
        if (n == 0)
            return 1;
        if (n< 0)
            return 0;
        int res = climbStairs1(n-1) + climbStairs1(n-2);
        return res;
    }
    // dp up_bottom
    private static int climbStairs2(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        else if (arr[n] != 0)
            return arr[n];
        else arr[n] = climbStairs2(n-1) + climbStairs2(n-2);
        return arr[n];
    }
    //dp bottom_up
    private static int climbStairs3(int n) {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;
        int first = 1 , second = 2;
        for (int i = 3; i <= n; i++) {
            int step = first + second;
            first = second;
            second = step;
        }
        return second;
    }
    public static void main(String[] args) {
        System.out.println("enter the number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        System.out.println("dp up_bottom: "+climbStairs2(n));
        System.out.println("dp bottom_up: "+climbStairs3(n));
        System.out.println("recursion: "+climbStairs1(n));

        int [] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("minCost: " + minCost(cost));
    }
    //minimum cost
    public static int minCost(int[] cost){
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        dp[cost.length] = Math.min(dp[cost.length-1], dp[cost.length-2]); // cost at top = 0 --> without + dp[cost.length]
        return dp[cost.length];
    }
}
