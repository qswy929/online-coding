package com.algorithm.leshi;

import java.util.Scanner;

//多少个子串是偶串（每一个字符都出现了偶数次）
public class Leshi_mazha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = Integer.valueOf(sc.nextInt());
            System.out.println(mazha(n));
        }
    }

    public static int mazha(int x) {
        x=Math.abs(x);
        int n = 0;
        while(n*(n+1)/2<x) {
            n++;
        }
        return ((n*(n+1)/2-x)%2==0) ? n : (n+1 + (n&1));
    }
}