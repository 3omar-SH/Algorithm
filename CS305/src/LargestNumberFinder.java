public class LargestNumberFinder {
    public static int largestNumberFinder(int [] array){
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Array cannot be null or empty");
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int [] array = {502,310,320,197,179,530,112};
        System.out.println("the largest number is : " + largestNumberFinder(array));
    }
}
