public class FindIdx {
    public static int Find(int[] array , int num){
        int m=0;
        int l= array.length-1;
        int mid = (m+l)/2;
        int ind;
        while (m <= l){
            if (num > array[mid]){
                m = mid +1;
                mid = (m+l)/2;
            }else if (num < array[mid]){
                l = mid - 1;
                mid = (m+l)/2;
            }else{
                break;
            }
        }
        ind = mid;
        if (num != array[mid]) {
            if (num < array[0]) {
                return 0;
            }else {
                ind++;
            }
        }
        return ind;
    }
    public static void main(String [] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(FindIdx.Find(arr, 5));
    }
}

