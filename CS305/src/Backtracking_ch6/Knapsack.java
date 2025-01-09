package Backtracking_ch6;

public class Knapsack {
    static int W , n , maxProfit , numBest;
    static int [] w , p , bestSet;
    static int[] include;
    static void Knapsack(int i, int profit, int weight) {
        if (weight <= W && profit > maxProfit) {
            maxProfit = profit;
            numBest = i;
            System.arraycopy(include, 0, bestSet, 0, n);
        }
        if (promising(i, profit, weight)) {
            if (i + 1 < n) {
                include[i + 1] = 1;
                Knapsack(i + 1, profit + p[i + 1], weight + w[i + 1]);
                include[i + 1] = 0;
                Knapsack(i + 1, profit, weight);
            }
        }
    }

    static boolean promising(int i, int profit, int weight) {
        if (weight >= W) {
            return false;
        } else {
            int j = i + 1;
            int totWeight = weight;
            float bound = profit;
            while (j < n && totWeight + w[j] <= W) {
                totWeight += w[j];
                bound += p[j];
                j++;
            }
            if (j < n) {
                bound += (W - totWeight) * ((float) p[j] / w[j]);
            }
            return bound > maxProfit;
        }
    }


    public static void main(String[] args) {
        W = 15;
        n = 4;
        w = new int[]{2, 5, 10, 6};
        p = new int[]{40, 30, 50, 10};
        bestSet = new int[n + 1];
        include = new int[n + 1];

        numBest = 0;
        maxProfit = 0;

        Knapsack(-1,0,0);

        for (int i = 0; i < n; i++){
            if (bestSet[i] == 1){
                System.out.println(w[i] + " : " + p[i]);
            }
        }
    }
}
