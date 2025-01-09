package divide_conquer.src;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,15,20,25,30,40,45,50};
        int high = arr.length;
        System.out.println(location(0 , high , 10 , arr));
    }
    static int location(int low , int high , int x , int[] arr){
        int mid = low + (high-low)/2;
        if (low > high) return -1;
        else if (arr[mid] == x) return mid;
        else if (arr[mid] < x) return location(mid + 1, high, x, arr);
        else return location(low, mid - 1, x, arr);
    }
}
