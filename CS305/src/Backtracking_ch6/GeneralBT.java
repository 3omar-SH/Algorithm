package Backtracking_ch6;
import java.util.ArrayList;
import java.util.List;

public class GeneralBT {
    private boolean promising(treeNode v){
        //promising logic
        return true;
    }
    //check if the treeNode is a solution
    private boolean isSolution(treeNode v){
        //solution check logic
        return v.value == 10;
    }
    //Backtracking method
    public void DFS(treeNode v){
        if (v == null) return;
        if (promising(v)){
            if (isSolution(v)){
                System.out.println("Solution found at treeNode: " + v.value);
            }else {
                for (treeNode u : v.children)
                    DFS(u);
            }
        }
    }
    public static void main(String[] args) {
        //create the tree
        treeNode root = new treeNode(1);
        treeNode child1 = new treeNode(2);
        treeNode child2 = new treeNode(3);
        
        root.addChild(child1);
        root.addChild(child2);

        child1.addChild(new treeNode(5));
        child1.addChild(new treeNode(6));

        child2.addChild(new treeNode(4));

        GeneralBT g = new GeneralBT();
        System.out.println("DFS traversal of the tree: ");
        g.DFS(root);
    }
}
class treeNode {
    int value;
    List<treeNode> children;
    public treeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    void addChild(treeNode child){
        children.add(child);
    }
}
