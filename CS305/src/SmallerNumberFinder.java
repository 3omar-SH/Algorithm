import java.util.Arrays;

public class SmallerNumberFinder {
    public static int[] smallerNumberFinder(int[] array , int m) {
        if (array.length < m)
            throw new IllegalArgumentException("m cannot be larger than the array length");
        Arrays.sort(array);
        int[] smallerNumbers = new int[m];
        for (int i = 0; i < m; i++) {
            smallerNumbers[i] = array[i];
        }
        return smallerNumbers;
    }
    public static void main(String[] args) {
        int[] array = {90 , 105 , 50 , 36 , 64 , 8};
        int m = 4;
        int[] smallerNumbers = smallerNumberFinder(array , m);
        System.out.println("the "+m+" smaller numbers are : "+Arrays.toString(smallerNumbers));
    }
}
