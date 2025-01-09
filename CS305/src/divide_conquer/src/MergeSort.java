import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr , left , right);
    }
    private static void merge(int[] arr , int[] left , int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    private static void mergeSort2(int [] arr){
        if (arr.length < 2) return;
        int mid1 = arr.length / 3;
        int mid2 =  2 * arr.length / 3;
        int[] left = Arrays.copyOfRange(arr, 0, mid1);
        int[] m = Arrays.copyOfRange(arr, mid1, mid2);
        int[] right = Arrays.copyOfRange(arr, mid2, arr.length);
        mergeSort2(left);
        mergeSort2(m);
        mergeSort2(right);
        merge(arr , left , m);
        merge(arr , Arrays.copyOfRange(arr , 0, mid2), right );
    }
    public static void main(String[] args) {
        int[] arr = {7,2,4,9,3,8,1,5,6};
        int[] arr2 = {5,2,3,4,9,6,8,1,7};
        mergeSort(arr);
        System.out.println("mergeSort  :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        mergeSort2(arr2);
        System.out.println("mergeSort 2 :");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
