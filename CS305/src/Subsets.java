public class Subsets {
    public static void Subsets(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    System.out.println("{ "+arr[i] + " , " + arr[j] + " , " + arr[k]+" }");
                    n++;
                }
            }
        }
        System.out.println(n);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Subsets(arr);
    }
}
