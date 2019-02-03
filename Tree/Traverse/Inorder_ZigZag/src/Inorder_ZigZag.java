import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=right=null;
    }
}
public class Inorder_ZigZag {
    public List<List<Integer>> zz_inorder(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack_right=new Stack<TreeNode>();
        Stack<TreeNode> stack_left=new Stack<TreeNode>();
        stack_left.push(root);


    }
}
