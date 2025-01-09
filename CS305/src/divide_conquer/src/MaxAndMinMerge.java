import java.util.Arrays;

public class MaxAndMinMerge {
    public static int FindMax(int[] arr){
        if (arr.length == 1)
            return arr[0];
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        int maxLeft = FindMax(left) , maxRight = FindMax(right);
        return Math.max(maxLeft, maxRight);
    }
    public static int Max2(int[] s , int l , int r){
        if (l == r) return s[l];
        int mid = (l + r)/2;
        int l1 = Max2(s, l, mid);
        int l2 = Max2(s, mid + 1, r);
        return Math.max(l1 , l2);
    }
    public static int FindMin(int[] arr){
        if (arr.length == 1)
            return arr[0];
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        int minLift = FindMin(left) , minRight = FindMin(right);
        return Math.min(minLift, minRight);
    }
    public static void main(String[] args) {
        int[] arr = {15,4,74,20};
        System.out.println("Max of array: "+FindMax(arr));
        System.out.println("Min of array: "+FindMin(arr));
        System.out.println("Max2 of array: "+Max2(arr , 0 , arr.length-1));
    }
}
