import java.util.Scanner;

public class Fib_dp {
    static long[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new long[n+1];
        System.out.println("fib 1: "+fib(n));
        System.out.println("fib 2: "+fib2(n));
        System.out.println("fib 3: "+fib3(n));
    }
    //bottom_up
    public static int fib(int n) {
        int [] arr = new int[n+1];
        arr[0] = 0;
        if (arr.length > 1)
            arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    //up_bottom
    public static long fib2(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (array[n] != 0)
            return array[n];
        else
            array[n] = fib2(n-1) + fib2(n-2);
        return array[n];
    }
    // recursion
    public static long fib3(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else return fib3(n-1) + fib3(n-2);
    }
}
