package com.algorithm.leecode;


// Given a binary tree, find its minimum depth.
public class Min_depth_of_tree {

    public int run(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        return Math.min(run(root.left),run(root.right))+1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
