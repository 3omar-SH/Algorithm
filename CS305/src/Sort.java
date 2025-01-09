import java.util.Arrays;

public class Sort {
    public static int[] sort(int[] arr) {
        int[] freq = new int[101] , result = new int[arr.length];
        for (int i : arr) {
            freq[i]++;
        }
        int pointer = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                result[pointer] = i;
                pointer++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] arr = {5 , 10 , 0 , 22 , 1 , 8 };
        System.out.println(Arrays.toString(Sort.sort(arr)));
    }
}
