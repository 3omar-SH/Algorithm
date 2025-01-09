import java.util.Scanner;

public class Calc {
    public int max(int[] arr ){
        return max(arr , arr.length-1);
    }
    private int max(int[] arr, int n){
        if (n == 0)
            return arr[0];
        else
            return Math.max(max(arr, n-1), arr[n]);
    }
    public int sum(int[] arr){
        return sum(arr , arr.length-1);
    }
    private int sum(int[] a, int n){
        if(n == 0) return a[0];
        return a[n] + sum(a, n-1);
    }
    public boolean isPalindrome(String s){
        return isPalindrome(s , 0 , s.length()-1);
    }
    private boolean isPalindrome(String s , int a , int b){
        s = s.toLowerCase();
        if(a == b) return true;
        if (s.charAt(a) != s.charAt(b)) return false;
        return isPalindrome(s , a+1 , b-1);
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        Scanner sc = new Scanner(System.in);
        int [] arr = {20 , 18 , 22 , 19 , 21};
        System.out.println("enter a string");
        String  s = sc.next();
        System.out.println("isPalindrome : "+calc.isPalindrome(s));
        System.out.println("sum : "+calc.sum(arr));
        System.out.println("max : "+calc.max(arr));

    }
}
