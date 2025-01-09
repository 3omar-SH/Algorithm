import java.util.Arrays;

public class PrimsAlgo{
    static final int inf = Integer.MAX_VALUE;
    // to find the vertex with the minimum weight
    private int minKay(int[] k , boolean [] mstSet , int n) {
        int min = inf;
        int min_index = -1 ;
        for (int i = 0; i < n; i++) {
            if (!mstSet[i] && min > k[i]) {
                min = k[i];
                min_index = i;
            }
        }
        return min_index;
    }
    //minimum Spanning Tree
    public void primMST(int[][] graph , int n){
        int[] parent = new int[n]; //to store parent node of each vertex
        int[] kay = new int[n]; //to store the minimum weight to reach each vertex
        boolean[] mstSet = new boolean[n]; //to track if a vertex is included in the mst
        Arrays.fill(kay, inf); //initialize all weight to a very large value
        kay[0] = 0;
        parent[0] = -1; //the root of mst has no parent
        for (int count = 0; count < n - 1; count++) {
            int u = minKay(kay,mstSet,n); //find the vertex with the smallest weight that isn't yet in mst
            mstSet[u] = true; //include the selected vertex in the mst
            // update the weights and parent for adjacent vertices
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < kay[v]) {
                    parent[v] = u;
                    kay[v] = graph[u][v];
                }
            }
        }
        printMST(parent , n , graph);
    }
    private void printMST(int[] parent , int n , int[][] graph){
        System.out.println("Edge \t Weight");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - "+ i +"\t\t"+ graph[i][parent[i]]);
        }
    }
    public static void main(String[] args) {
        int [][] graph = {
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
        int n = graph.length;
        PrimsAlgo pa = new PrimsAlgo();
        pa.primMST(graph , n);
    }
}
/*
 {0,4,inf,inf,inf,inf,inf,8,inf},
                {4,0,8,inf,inf,inf,inf,inf,inf},
                {inf,8,0,7,inf,4,inf,inf,2},
                {inf,inf,7,0,9,14,inf,inf,inf},
                {inf,inf,inf,9,0,10,inf,inf,inf},
                {inf,inf,5,14,10,0,2,inf,inf},
                {inf,inf,inf,inf,inf,2,0,1,6},
                {8,11,inf,inf,inf,inf,1,0,7},
                {inf,inf,2,inf,inf,inf,6,7,0}
 */