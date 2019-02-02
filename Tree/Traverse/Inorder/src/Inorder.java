//package com.company;

import java.util.Stack;

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
        System.out.println(root.val);
        inorder_recursive(root.right);
    }
    public void inorder_stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pop = null;
        if(cur==null){return ;}
        stack.push(cur);
        while(!stack.isEmpty()) {
            while (cur.left != null) {
                cur = cur.left;
                stack.push(cur);
            }
            pop = stack.pop();
            System.out.println(pop.val);
            cur = pop.right;
            if(cur!=null){
                stack.push(cur);
            }
        }
    }
    public static void main(String[] args) {
        // write your code here
        TreeNode root = new TreeNode(1);
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(7);
        TreeNode D = new TreeNode(9);
        TreeNode E = new TreeNode(3);
        TreeNode F = new TreeNode(10);

        root.left = A;
        root.right = B;
        A.left = C;
        A.right = D;
        B.left = E;
        D.left = F;
        Inoder s1 = new Inoder();
        s1.inorder_stack(root);
    }
}

