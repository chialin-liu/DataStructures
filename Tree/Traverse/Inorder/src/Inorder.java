//package com.company;

import java.util.ArrayList;
import java.util.List;
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
    //@Leetcode:94
    public List<Integer> inorder_stack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> inorder_list = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pop = null;
        if(cur==null){
           // inorder_list.add(cur.val);
            return inorder_list;
        }
        stack.push(cur);
        while(!stack.isEmpty()) {
            while (cur != null) {
                cur = cur.left;
                if(cur!=null){
                    stack.push(cur);
                }
            }
            pop = stack.pop();
            inorder_list.add(pop.val);
            //System.out.println(pop.val);
            cur = pop.right;
            if(cur!=null){
                stack.push(cur);
            }
        }
        return inorder_list;
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
        TreeNode NU=null;
        List<Integer> list = new ArrayList<>();
        list=s1.inorder_stack(NU);
        for(int n: list){
            System.out.println(n);
        }
    }
}

