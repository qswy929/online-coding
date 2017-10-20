package com.algorithm.xiaomi;

import java.util.Scanner;

/* 现在有一棵合法的二叉树，树的节点都是用数字表示，
现在给定这棵树上所有的父子关系，求这棵树的高度
 */

public class Tree_length {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int node[]=new int[n];
        int i;
        for(i=0;i<n;i++) {
            node[i] = -1;
        }
        for(i=0;i<n-1;i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            node[child]=parent;
        }
        int maxLength=1;
        for(i=0;i<n;i++) {
            int current=1;
            int k=i;
            while(node[k]!=-1) {
                current++;
                k=node[k];
            }
            if(current>maxLength) {
                maxLength = current;
            }
        }
        System.out.println(maxLength);
    }
}