import java.util.Scanner;

public class Graph {
    int v , e ;
     int [][] adj_matrix;
     int [][] dist;
     int [][] p;

     public Graph(int v, int e) {
         this.v = v;
         this.e = e;
         adj_matrix = new int[v+1][v+1];
         dist = new int[v+1][v+1];
         p = new int[v+1][v+1];
         for (int i=1; i<=v; i++){
             for (int j=1; j<=v; j++){
                 dist[i][j] = 99999;
             }
             dist[i][i] = 0;
         }
     }
     public void floyd(){
         for (int k = 1; k <= v; k++) {
             for (int i = 1; i <= v; i++) {
                 for (int j = 1; j <= v; j++) {
                     if (dist[i][k] + dist[k][j] < dist[i][j]) {
                         dist[i][j] = dist[i][k] + dist[k][j];
                     }
                 }
             }
         }
     }
    public void floyd2(){
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        p[i][j] = k;
                    }
                }
            }
        }
    }
    public void path(int q , int r){
         if (p[q][r] != 0){
             path(q , p[q][r]);
             System.out.println("v" + p[q][r] + " ");
             path(p[q][r], r);
         }
    }

     public void printGraph() {
         for (int i = 1; i <= v; i++) {
             for (int j = 1; j <= v; j++) {
                 System.out.print(adj_matrix[i][j] + " ");
             }
             System.out.println();
         }
     }
     public void print_disMatrix(){
         for (int i = 1; i <= v; i++) {
             for (int j = 1; j <= v; j++) {
                 System.out.print(dist[i][j] + " ");
             }
             System.out.println();
         }
     }
     public void print_distant(){
         for (int i = 1; i <= v; i++) {
             for (int j =i+1; j <= v; j++) {
                 System.out.println(i+" to "+ j+" = " +dist[i][j] + " ");
             }
             System.out.println();
         }
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(v, e);
        int c,d;
        while (e-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            String ans1 = sc.next();
            if (ans1.equals("yes")){
                c = sc.nextInt();//from a to b what is the weight
                g.adj_matrix[a][b] = c;
                g.dist[a][b] = c;
            }
            String ans2 = sc.next();
            if (ans2.equals("yes")){
                d = sc.nextInt();//from b to a what is the weight
                g.adj_matrix[b][a] = d;
                g.dist[b][a] = d;
            }
        }
        g.floyd();
        g.printGraph();
        System.out.println();
        g.print_disMatrix();
        System.out.println();
        g.print_distant();
        g.floyd2();
        g.path(3 , 4);
    }
}
/*
4 4
1 2 yes 1 no
1 3 yes 1 no
2 3 yes 3 yes 2
2 4 yes 4 no
 */
