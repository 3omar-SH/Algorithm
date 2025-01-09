public class SmallAndLarg {
    public static void SAndL(int [] array) {
        int min = array[array.length-1];
        int max = array[array.length-1];
        for (int i=0 ; i<array.length-1 ;i+=2){
            if (array[i] > array[i+1]){
                min = Math.min(min, array[i+1]);
                max = Math.max(max, array[i]);
            }else {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i + 1]);
            }
        }
        System.out.println("Max is : " + max + " min is : " + min);
    }
    public static void FindSAndL(int [] array) {
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length / 2; i++) {
            if (array[2 * i] > array[2 * i + 1]) {
                max = Math.max(max, array[2 * i]);
                min = Math.min(min, array[2 * i + 1]);
            } else {
                max = Math.max(max, array[2 * i + 1]);
                min = Math.min(min, array[2 * i]);
            }
        }
        System.out.println("Max is : " + max + " min is : " + min);
    }

    public static void main(String[] args) {
        SAndL(new int [] {1,2,3,4,5,0,80,-1});
        FindSAndL(new int [] {22,43,55,4,5,10});
    }
}
