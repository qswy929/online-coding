package com.algorithm.jinritoutiao;

import java.util.Scanner;

public class TouTiao_Yihuo {
    // 今日头条：两两异或大于m的组数
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int i;
       long count = 0;
       int[] A = new int[n];
       TrieNode root = new TrieNode(-1);
       for(i=0;i<n;i++) {
           A[i] = sc.nextInt();
           insert(root, A[i]);
       }
       for(int a : A) {
           count += query(root,a,m,16);
       }
        System.out.println(count/2);
    }

    public static void insert(TrieNode root, int num) {
        TrieNode current = root;
        int i;
        for (i = 16; i >= 0; i--) {
            int n = (num >> i) & 1;
            if (current.next[n] == null) {
                current.next[n] = new TrieNode(n);
            }
            current = current.next[n];
            current.count++;
        }
    }

    /*
     * @param root//trieTree树
     * @param a//a是做异或运算的其中的一个值
     * @param m//和异或结果进行比较的数字，大于m记录值加1
     * @param k//number转换为二进制后对应的第k位置上的数字
     * @return
     */
    public static int query(TrieNode root, int a, int m, int k) {
        if (root == null) {
            return 0;
        }
        TrieNode current = root;
        for (int i = k; i >= 0; i--) {
            int aDigit = (a >> i) & 1;  //取二进制第17-i位的值
            int mDigit = (m >> i) & 1;
            if (aDigit == 1 && mDigit == 1) {
                if (current.next[0] == null) {//对应k位置处的数字若为空，则返回0
                    return 0;
                } else {
                    current = current.next[0]; // 取下一位进行比较
                }
            } else if (aDigit == 0 && mDigit == 1) {
                if (current.next[1] == null) {
                    return 0;
                } else {
                    current = current.next[1]; // 取下一位进行比较
                }
            } else if (aDigit == 0 && mDigit == 0) {
                int p = query(current.next[0], a, m, i - 1);  //b的该位为0，对余下的位数进行比较
                int q = (current.next[1] == null ? 0 : current.next[1].count);  //b的该位为1，则a^b>m
                return p + q;
            } else if (aDigit == 1 && mDigit == 0) {
                int p = query(current.next[1], a, m, i - 1);
                int q = (current.next[0] == null ? 0 : current.next[0].count); //b的该位为0，则a^b>m
                return p + q;
            }
        }
        return 0;
    }
}

class TrieNode {
    int count=0;
    int digit=0;
    TrieNode[] next = new TrieNode[2];
    public TrieNode(int digit) {
        this.digit = digit;
    }
}

