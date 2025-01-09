package Backtracking_ch6;
import java.util.*;

class KNode {
    int level, profit, weight;

    public KNode() {
    }

    public KNode(KNode copy) {
        this.level = copy.level;
        this.profit = copy.profit;
        this.weight = copy.weight;
    }
}

class Knapsack3 {
    static int[] p, w;
    static int W;
    static int n;
    static int maxProfit;

    static float bound1(KNode u) {
        int j, k;
        int totWeight;
        float result;

        if (u.weight >= W)
            return 0;
        else {
            result = u.profit;
            j = u.level + 1;
            totWeight = u.weight;
            while ((j < n) && (totWeight + w[j] <= W)) {
                totWeight += w[j];
                result += p[j];
                j++;
            }
            k = j;
            if (k < n)
                result += (W - totWeight) * ((float) p[k] / w[k]);
            return result;
        }
    }

    static void knapsack3(int[] p, int[] w, int W, int n) {
        Knapsack.p = p;
        Knapsack.w = w;
        Knapsack.W = W;
        Knapsack.n = n;
        maxProfit = 0;

        Queue<KNode> Q = new LinkedList<>();
        KNode v = new KNode();

        v.level = -1;
        v.profit = 0;
        v.weight = 0;
        Q.add(v);

        while (!Q.isEmpty()) {
            v = Q.poll();

            if (v.level == -1)
                v.level = 0;
            if (v.level == n - 1)
                continue;
            KNode u = new KNode(v);
            u.level = v.level + 1;

            // Including the next item
            u.weight = v.weight + w[u.level];
            u.profit = v.profit + p[u.level];

            if (u.weight <= W && u.profit > maxProfit)
                maxProfit = u.profit;

            if (bound1(u) > maxProfit)
                Q.add(new KNode(u));

            // Excluding the next item
            u.weight = v.weight;
            u.profit = v.profit;
            if (bound1(u) > maxProfit)
                Q.add(new KNode(u));
        }
    }

    public static void main(String[] args) {
        int[] p = { 60, 100, 50 };
        int[] w = { 10, 20, 30 };
        int W = 50;
        int n = p.length;
        knapsack3(p, w, W, n);
        System.out.println("Maximum profit is " + maxProfit);
    }
}
