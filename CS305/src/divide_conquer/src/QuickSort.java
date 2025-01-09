import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] arr , int low , int high) {
        if (high > low) {
           int pivot = partition(arr , low , high);
            quickSort(arr , low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    private int partition(int[] arr , int low , int high) {
        int pivotItem = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] <= pivotItem) {
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivotItem;
        return j;
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {7,2,4,9,3,8,1,5,6};
        int n = arr.length;
        quickSort.quickSort(arr , 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
