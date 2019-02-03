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
public class LevelOrder_ZigZag {
    public List<List<Integer>> zz_scan(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list_1d_left= new ArrayList<Integer>();
        List<Integer> list_1d_right= new ArrayList<Integer>();
        Stack<TreeNode> stack_right = new Stack<TreeNode>();
        Stack<TreeNode> stack_left = new Stack<TreeNode>();
        stack_left.push(root);
        TreeNode pop = null;
        int line = -1;
        if(root==null){return null;}
        while((!stack_left.isEmpty())|(!stack_right.isEmpty())){
            list_1d_left = new ArrayList<Integer>();
            while(!stack_left.isEmpty()){
                pop = stack_left.pop();
                list_1d_left.add(pop.val);
                if(pop.left!=null){
                    stack_right.push(pop.left);
                }
                if(pop.right!=null){
                    stack_right.push(pop.right);
                }
            }
            if(list_1d_left.size()!=0){list.add(list_1d_left);}
            list_1d_right = new ArrayList<Integer>();
            while(!stack_right.isEmpty()){
                pop = stack_right.pop();
                list_1d_right.add(pop.val);
                if(pop.right!=null){
                    stack_left.push(pop.right);
                }
                if(pop.left!=null){
                    stack_left.push(pop.left);
                }
            }
            if(list_1d_right.size()!=0){list.add(list_1d_right);}
        }
        return list;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode A = new TreeNode(9);
        TreeNode B = new TreeNode(20);
        TreeNode C = new TreeNode(15);
        TreeNode D = new TreeNode(7);
        root.left=A;
        root.right=B;
        B.left=C;
        D.right=D;
        TreeNode empty = null;
        LevelOrder_ZigZag s1 = new LevelOrder_ZigZag();
        List<List<Integer>> list = s1.zz_scan(empty);
        for(List<Integer> ll:list){
            if(!ll.isEmpty()){
                System.out.println(ll);
            }
        }
    }
}

