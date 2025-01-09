public class Find_city {
    public static int find_city(int n , int [][] edges , int distanceThreshold) {
        int [][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = 77777;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2]; // dist[0][1]= 3
        }
        floyd(n , dist);
        /*
        0 3 4 5 cnt = 2
        3 0 1 2 cnt = 3
        4 1 0 1 cnt = 3
        5 2 1 0 cnt = 2
        */
        int ans = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold && i != j) {
                    cnt++;
                }
            }
            /*
            cnt = 2 , ans = max_value
            cnt = 3 , ans = 2 xxxx , res = 0
            cnt = 3 , ans = 2 xxxx , res = 0
            cnt = 2 , ans = 2 , res = 3
             */
            if (cnt <= ans){
                ans = cnt;
                res = i;
            }
        }
        return res;
    }
    public static void floyd(int n , int [][] dist){
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
    public static void main(String[] args) {
        int[][] edges = {
                {0,1,3} ,
                {1,2,1} ,
                {1,3,4} ,
                {2,3,1}
        };
        System.out.println(find_city(4 , edges, 4));
    }
}
