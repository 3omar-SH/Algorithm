public class Connect_floyd {
    static final int inf = 99999;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 2 , 5},
                {4, 0 , 7},
                {3, 1 , 0}
        };
        solveFloydWarshall(graph);
        if (connect(graph)){
            System.out.println("the graph is connected");
        }else
            System.out.println("the graph is not connected");
    }
    public static void solveFloydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = inf;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    public static boolean connect(int[][] graph){
        boolean result = true;
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == inf) {
                    result = false;
                    break;
                }
            }
            if (!result) break;
        }
        return result;
    }
}
