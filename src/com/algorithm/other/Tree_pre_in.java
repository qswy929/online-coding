package com.algorithm.other;

import java.util.*;

//前序和中序，构造树；并且层次遍历
public class Tree_pre_in {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        int i;
        int[] pre = new int[len];
        int[] in = new int[len];
        String[] s = sc.nextLine().split(" ");
        for(i=0;i<len;i++) {
            pre[i] = Integer.valueOf(s[i]);
        }
        s = sc.nextLine().split(" ");
        for(i=0;i<len;i++) {
            in[i] = Integer.valueOf(s[i]);
        }
        TreeNode t = reConstructBinaryTree(pre, in);
       print(t);
    }

    //根据前序和中序构造二叉树
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
    }

    //层次遍历
    public static void print(TreeNode tree) {
        Queue<TreeNode> q = new LinkedList<>();
        if(tree!=null) {
            q.offer(tree);
        }
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            System.out.print(t.value + " ");
            if(t.left!=null) {
                q.offer(t.left);
            }
            if(t.right!=null) {
                q.offer(t.right);
            }

        }
    }


}

class TreeNode {
    public int value;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode (int value) {
        this.value = value;
    }
}
