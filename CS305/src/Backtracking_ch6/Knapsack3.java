package Backtracking_ch6;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int level;
    int profit;
    int weight;
    double bound;

    @Override
    public int compareTo(Node other) {
        return Double.compare(other.bound, this.bound); // نريد أكبر قيمة للحد الأعلى
    }
}

public class Knapsack3 {
    static int bound(Node u, int n, int W, int[] p, int[] w) {
        if (u.weight >= W) {
            return 0;
        }
        int profit_bound = u.profit;
        int j = u.level + 1;
        int totweight = u.weight;

        while ((j < n) && (totweight + w[j] <= W)) {
            totweight += w[j];
            profit_bound += p[j];
            j++;
        }

        if (j < n) {
            profit_bound += (W - totweight) * p[j] / w[j];
        }

        return profit_bound;
    }

    public static void knapsack3(int n, int[] p, int[] w, int W) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        Node u, v = new Node();

        v.level = -1;
        v.profit = 0;
        v.weight = 0;
        int maxprofit = 0;
        v.bound = bound(v, n, W, p, w);
        PQ.add(v);

        while (!PQ.isEmpty()) {
            v = PQ.poll();

            if (v.bound > maxprofit) {
                u = new Node();
                u.level = v.level + 1;
                u.weight = v.weight + w[u.level];
                u.profit = v.profit + p[u.level];

                if (u.weight <= W && u.profit > maxprofit) {
                    maxprofit = u.profit;
                }

                u.bound = bound(u, n, W, p, w);
                if (u.bound > maxprofit) {
                    PQ.add(u);
                }

                u = new Node();
                u.level = v.level + 1;
                u.weight = v.weight;
                u.profit = v.profit;
                u.bound = bound(u, n, W, p, w);
                if (u.bound > maxprofit) {
                    PQ.add(u);
                }
            }
        }

        System.out.println("Maximum profit is: " + maxprofit);
    }

    public static void main(String[] args) {
        int[] p = {60, 100, 50};
        int[] w = {10, 20, 30};
        int W = 50;
        int n = p.length;

        knapsack3(n, p, w, W);
    }
}

