package Backtracking_ch6;

public class SumOfSubsets {
    static int W;
    static String[] include;
    public static boolean promising(int  i , int weight , int total , int[] w){
        return (weight + total >= W) && (weight == W || weight + w[i] <= W);
    }
    public static void sum_of_subsets(int i , int weight , int total , int[] w){
        if (promising(i , weight , total , w)){
            if (weight == W){
                for (int j = 0; j < i; j++){
                    if (include[j] == "yes")
                        System.out.print(w[j] + " ");
                }
                System.out.println();
            }else {
                include[i] = "yes";
                sum_of_subsets(i + 1, weight + w[i], total - w[i] , w);
                include[i] = "no";
                sum_of_subsets(i + 1, weight, total - w[i] , w);
            }
        }
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        W = 5;
        include = new String[w.length + 1];
        for (int i = 0; i < w.length; i++){
            include[i] = "no";
        }
        sum_of_subsets(0 , 0 , 15 , w);
    }
}
