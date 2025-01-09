import java.util.Arrays;

public class TravelingSalesmanProblem {
    private static final int INF = Integer.MAX_VALUE;

    public static int tsp(int[][] graph, int start) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1; // حالة زيارة كل المدن
        int[][] dp = new int[n][(1 << n)];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return tspUtil(graph, start, 1 << start, VISITED_ALL, dp);
    }

    private static int tspUtil(int[][] graph, int current, int visited, int VISITED_ALL, int[][] dp) {
        if (visited == VISITED_ALL) {
            return graph[current][0]; // العودة إلى العقدة الأصلية
        }

        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        int minCost = INF;

        for (int next = 0; next < graph.length; next++) {
            if ((visited & (1 << next)) == 0 && graph[current][next] != INF) {
                int cost = graph[current][next] + tspUtil(graph, next, visited | (1 << next), VISITED_ALL, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        dp[current][visited] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        System.out.println("Minimum cost of TSP: " + tsp(graph, 0));
    }
}
/*
وصف المشكلة:
لديك عدد من المدن، وتريد أن تزور كل مدينة مرة واحدة فقط ثم تعود إلى المدينة الأصلية. الهدف هو إيجاد المسار الأقل تكلفة.

مثال:
افترض أن لديك 4 مدن بمصفوفة المسافات التالية:

A	B	C	D
A	0	10	15	20
B	10	0	35	25
C	15	35	0	30
D	20	25	30	0

النتيجة:
عند تشغيل الكود، سيعرض أقل تكلفة لزيارة جميع المدن ثم العودة إلى البداية. في المثال أعلاه:

Minimum cost of TSP: 80

شرح النتيجة:
المسار: A → B → D → C → A.
التكلفة: 10 + 25 + 30 + 15 = 80.
 */
