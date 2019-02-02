class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=right=null;
    }
}
public class CheckBT {
    public boolean checkSameBT(TreeNode A, TreeNode B){
    //    Stack<TreeNode> stackA=new Stack<TreeNode>();
    //    Stack<TreeNode> stackB=new Stack<TreeNode>();
    //    TreeNode curA=A;
    //    TreeNode curB=B;
    //    while(curA!=null){
    //        stackA.push(curA);
    //
    //    }
        //static boolean root = true;
        boolean BOOL;
        if((A==null)&(B==null)){
            return true;
        }
        else if((A==null)&(B!=null)){
            return false;
        }
        else if((A!=null)&(B==null)){
            return false;
        }
        BOOL=checkSameBT(A.left,B.left);
        if(BOOL==false){return false;}
        if(A.val!=B.val){
            BOOL=false;
            return false;
        }
        BOOL=checkSameBT(A.right,B.right);
        if(BOOL==false){return false;}
        return BOOL;
    }
    public static void main(String []args){
        TreeNode R1 = new TreeNode(1);
        TreeNode A1 = new TreeNode(5);
        TreeNode B1 = new TreeNode(6);
        TreeNode C1 = new TreeNode(7);
        TreeNode D1 = new TreeNode(9);
        R1.left=A1;
        R1.right=B1;
        A1.left=C1;
        A1.right=D1;

        TreeNode R2 = new TreeNode(1);
        TreeNode A2 = new TreeNode(5);
        TreeNode B2 = new TreeNode(6);
        TreeNode C2 = new TreeNode(7);
        TreeNode D2 = new TreeNode(8);
        R2.left=A2;
        R2.right=B2;
        A2.left=C2;
        A2.right=D2;
        CheckBT s1=new CheckBT();
        boolean RESULT = s1.checkSameBT(R1,R2);
        System.out.println(RESULT);
    }
}
