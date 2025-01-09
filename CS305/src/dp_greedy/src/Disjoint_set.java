package dp_greedy.src;

public class Disjoint_set {
    int[] arr;

    public Disjoint_set(int n) {
        arr = new int[n + 1];
        initial();
    }

    public void initial() {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public int find(int n) {
        int j = n;
        while (arr[j] != j) {
            j = arr[j];
        }
        return j;
    }

    public boolean equal(int p, int q) {
        if (p == q) return true;
        else return false;
    }

    public void merge(int p, int q) {
        if (p < q)
            arr[q] = p;
        else
            arr[p] = q;
    }

}
