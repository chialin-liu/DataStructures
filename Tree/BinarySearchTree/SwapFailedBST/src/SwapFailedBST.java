import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=null;
        right=null;
    }
}
public class SwapFailedBST {
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode pop;
        while(!queue.isEmpty()){
            pop=queue.poll();
            if(pop.left!=null){
                queue.add(pop.left);
            }
            System.out.println(pop.val);
            if(pop.right!=null){
                queue.add(pop.right);
            }
        }
    }
    public TreeNode inorder_recover(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode first = null;
        TreeNode middle = null;
        TreeNode last = null;
        TreeNode pre = null;
        stack.push(root);
        TreeNode cur = root;
        TreeNode pop = null;
        int one_time = 0;
        while(!stack.isEmpty()){
            while(cur!=null) {
                cur = cur.left;
                if(cur!=null) {
                    stack.push(cur);
                }
            }
            pre = pop;
            pop = stack.pop();
            if(pre!=null) {
                if ((pre.val > pop.val) & (one_time == 0)) {
                    first = pre;
                    middle = pop;
                    one_time = 1;
                } else if ((pre.val > pop.val) & (one_time == 1)) {
                    last = pop;
                    one_time = 2;
                }
            }
            //System.out.println(pop.val);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            cur=pop.right;
        }
        int temp;
        if(one_time == 1){
            temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
        else if(one_time == 2){
            temp = first.val;
            first.val=last.val;
            last.val=temp;
        }
        return root;
    }
    public void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = root;
        TreeNode pop = null;
        while (!stack.isEmpty()) {
            while (cur != null) {
                cur = cur.left;
                if (cur != null) {
                    stack.push(cur);
                }
            }
            pop = stack.pop();
            System.out.print(pop.val+"->");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            cur = pop.right;
        }
    }
    public static void main(String []args){
        TreeNode R1 = new TreeNode(10);
        TreeNode A1 = new TreeNode(8);
        TreeNode B1 = new TreeNode(11);
        TreeNode C1 = new TreeNode(7);
        TreeNode D1 = new TreeNode(9);
        //R1.left=A1;
        //R1.right=B1;
        //A1.left=C1;
        //A1.right=D1;
        //recover
        R1.left=B1;
        R1.right=A1;
        B1.left=C1;
        B1.right=D1;
        SwapFailedBST s1 = new SwapFailedBST();
        System.out.println("Orginal:");
        s1.inorder(R1);
        TreeNode new_root= s1.inorder_recover(R1);
        System.out.println("Reocover:");
        s1.inorder(new_root);
    }
}
