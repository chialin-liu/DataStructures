//package com.company;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int a){
        val=a;
        left=null;
        right=null;
    }
}
class Inoder {
    public void inorder_recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder_recursive(root.left);
        System.out.println(root);
        inorder_recursive(root.right);
    }

    public static void main(String[] args) {
        // write your code here
        TreeNode root = new TreeNode(1);
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(7);
        TreeNode D = new TreeNode(9);
        TreeNode E = new TreeNode(3);

        root.left = A;
        root.left = B;
        A.left = C;
        A.right = D;
        B.left = E;
        Inoder s1 = new Inoder();
        s1.inorder_recursive(root);
    }
}

