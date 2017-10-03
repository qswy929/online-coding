package com.algorithm.other;

//根据中序和后序重建二叉树
public class Tree_middle_post {

    static int pInorder,pPostorder;
    public static void main(String[] args) {
        char[] in = {'A','D','E','F','G','H','M','Z'};
        char[] post = {'A','E','F','D','H','Z','M','G'};
        TreeNode t = buildTree(in,post);
        print(t);
    }

    //前序遍历
    public static void print(TreeNode t) {
        if(t != null) {
            System.out.print(t.value+" ");
            print(t.left);
            print(t.right);
        }
    }

    private static TreeNode buildTree(char[] inorder, char[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }

        // create root node
        TreeNode n = new TreeNode(postorder[pPostorder--]);

        // if right node exist, create right subtree
        if (inorder[pInorder] != n.value) {
            n.right = buildTree(inorder, postorder, n);
        }

        pInorder--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[pInorder] != end.value)) {
            n.left = buildTree(inorder, postorder, end);
        }

        return n;
    }

    public static TreeNode buildTree(char[] inorder, char[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }


}