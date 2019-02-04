class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=right=null;
    }
}
public class balance {
    public boolean checkBalance(TreeNode root){
        int left_height;
        int right_height;
        if(root==null){
            return true;
        }
        left_height = height(root.left);
        right_height= height(root.right);
        //if((((left_height-right_height)<=1)|((right_height-left_height)<=1))&(checkBalance(root.left))&(checkBalance(root.right))){
        if((abs(left_height-right_height)<=1)&(checkBalance(root.left))&(checkBalance(root.right))){
            return true;
        }
        return false;
    }
    public int abs(int a){
        if(a<0){
            return -a;
        }
        else{
            return a;
        }
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+max(height(root.left),height(root.right));
    }
    public int max(int a, int b){
        int tmp= (a>b)?a:b;
        return tmp;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode A = new TreeNode(9);
        TreeNode B = new TreeNode(20);
        TreeNode C = new TreeNode(15);
        TreeNode D = new TreeNode(7);
        root.left = A;
        root.right = B;
        B.left = C;
        B.right = D;
        balance b1 = new balance();
        boolean bb=b1.checkBalance(root);
        System.out.println("True or False:" + bb);
    }
}
