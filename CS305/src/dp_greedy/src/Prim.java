package dp_greedy.src;

public class Prim {
    static final int inf = Integer.MAX_VALUE;
    public static void prim(int n, int[][] W) {
        int[] nearest = new int[n];
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int maxV = inf;
        for (int i = 1; i < n; i++) {
            nearest[i] = 0;
            if (W[0][i]==0)
                distance[i] = maxV;
            else
                distance[i]=W[0][i];
        }

        for (int k = 0; k < n - 1; k++) {
            int min = inf;
            int vnear = -1;

            for (int i = 1; i < n; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    vnear = i;
                }
            }
            System.out.println(nearest[vnear] + " - " + vnear +" ===> "+ distance[vnear]);

            visited[vnear] = true;
            for (int i = 1; i < n; i++) {
                if (!visited[i] && W[vnear][i] != 0 && W[vnear][i] < distance[i]) {
                    distance[i] = W[vnear][i];
                    nearest[i] = vnear;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0,4,inf,inf,inf,inf,inf,8,inf},
                {4,0,8,inf,inf,inf,inf,inf,inf},
                {inf,8,0,7,inf,4,inf,inf,2},
                {inf,inf,7,0,9,14,inf,inf,inf},
                {inf,inf,inf,9,0,10,inf,inf,inf},
                {inf,inf,5,14,10,0,2,inf,inf},
                {inf,inf,inf,inf,inf,2,0,1,6},
                {8,11,inf,inf,inf,inf,1,0,7},
                {inf,inf,2,inf,inf,inf,6,7,0}
        };
        prim(graph.length, graph);
    }
}
