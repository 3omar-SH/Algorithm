package dp_greedy.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kruskal {
    public static void kruskal(int n, int m, List<Edge> E , List<Edge> F) {
        int p , q;
        Edge e ;
        Collections.sort(E);
        Disjoint_set ds = new Disjoint_set(n);
        int k = 0;
        while (F.size() < n - 1) {
            e = E.get(k++);
            p = ds.find(e.src);
            q = ds.find(e.dest);
            if (!ds.equal(p, q)){
                F.add(e);
                ds.merge(p, q);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of vertices & Edges");
        int n = in.nextInt(); //8
        int m = in.nextInt(); //14
        List<Edge> E = new ArrayList<>();
        E.add(new Edge(0,1,4));
        E.add(new Edge(0,7,8));
        E.add(new Edge(1,2,8));
        E.add(new Edge(1,7,11));
        E.add(new Edge(2,3,7));
        E.add(new Edge(2,8,2));
        E.add(new Edge(2,5,4));
        E.add(new Edge(3,4,9));
        E.add(new Edge(3,5,14));
        E.add(new Edge(4,5,10));
        E.add(new Edge(5,6,2));
        E.add(new Edge(6,7,1));
        E.add(new Edge(6,8,6));
        E.add(new Edge(7,8,7));
        List<Edge> F = new ArrayList<>();
        kruskal(n, m , E , F);
        System.out.println("Edges in the Minimum Spanning Tree : ");
        for (Edge e : F) {
            System.out.println(e.src + " -- " + e.dest + " ==> " + e.weight);
        }
    }
}
