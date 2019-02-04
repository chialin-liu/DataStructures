import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=right=null;
    }
}
public class LevelOrder_BU {
    public List<List<Integer>> LevelORder_BU(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue_left = new LinkedList<TreeNode>();
        Queue<TreeNode> queue_right = new LinkedList<TreeNode>();
        List<Integer> l_left = new ArrayList<>();
        List<Integer> l_right = new ArrayList<>();
        queue_left.add(root);
        TreeNode pop;
        if(root==null){return list;}
        while((!queue_left.isEmpty())|(!queue_right.isEmpty())){
            while(!queue_left.isEmpty()) {
                pop = queue_left.poll();
                if (pop.left != null) {
                    queue_right.add(pop.left);
                }
                if (pop.right != null) {
                    queue_right.add(pop.right);
                }
                l_left.add(pop.val);
            }
            if(l_left.size()!=0){list.add(0,l_left);}
            while(!queue_right.isEmpty()) {
                pop = queue_right.poll();
                if (pop.left != null) {
                    queue_left.add(pop.left);
                }
                if (pop.right != null) {
                    queue_left.add(pop.right);
                }
                l_right.add(pop.val);
            }
            if(l_right.size()!=0){list.add(0,l_right);}
            l_left = new ArrayList<Integer>();
            l_right = new ArrayList<Integer>();
        }

        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode A = new TreeNode(9);
        TreeNode B = new TreeNode(20);
        TreeNode C = new TreeNode(15);
        TreeNode D = new TreeNode(7);
        root.left = A;
        root.right = B;
        B.left = C;
        B.right = D;
        LevelOrder_BU s1 = new LevelOrder_BU();
        List<List<Integer>> list = s1.LevelORder_BU(root);
        for (List<Integer> ll : list) {
            if (!ll.isEmpty()) {
                System.out.println(ll);
            }
        }
    }
}
