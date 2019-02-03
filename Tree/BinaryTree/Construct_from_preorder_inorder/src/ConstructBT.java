import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=right=null;
    }
}
//@ from preorder and inorder, construct BT
public class ConstructBT {
    public TreeNode construcBT(int[] preorder, int [] inorder){
        TreeNode root = buildTree(preorder,inorder,0,preorder.length-1);
        return root;
    }
    int pre_index = 0;
    public TreeNode buildTree(int [] pre, int [] in, int start, int end){
        TreeNode root = null;
        //if(pre_index<pre.length){
        //}
        //if(root==null){
        if(start>end){
            return null;
        }
        root = new TreeNode(pre[pre_index]);
        pre_index++;
        if(start==end){
            return root;
        }
        int inorder_index = FindIndexInorder(in, root.val);
        root.left = buildTree(pre,in,start,inorder_index-1);
        root.right = buildTree(pre,in,inorder_index+1,end);
        return root;
    }
    public int FindIndexInorder(int []in, int val){
        for(int i=0;i<in.length;i++){
            if(val==in[i]){
                return i;
            }
        }
        return 0;
    }
    public void LevelOrder(TreeNode root){
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        TreeNode pop;
        while(!stack.isEmpty()){
            pop = stack.poll();
            if(pop.left!=null){
                stack.add(pop.left);
            }
            if(pop.right!=null){
                stack.add(pop.right);
            }
            System.out.print(pop.val+"->");
        }
    }
    public static void main(String []args){
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(9);
        TreeNode C = new TreeNode(7);
        TreeNode D = new TreeNode(8);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(3);

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        ConstructBT S1 = new ConstructBT();
      //  int [] pre = {7,-10,-4,3,-1,2,-8,11};
      //  int [] in  = {-4,-10,3,-1,7,11,-8,2};
        int [] pre = {-1};
        int [] in  = {-1};
        TreeNode root;
        root=S1.construcBT(pre, in);
        S1.LevelOrder(root);
    }
}
