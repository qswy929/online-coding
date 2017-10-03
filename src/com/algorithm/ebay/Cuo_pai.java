package com.algorithm.ebay;

import java.util.Scanner;


// 1-1/2!+1/3!- ...+ (-1)^N/N!(至少有一个人拿到自己帽子的概率)


public class Cuo_pai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ji = 1;
        long i;
        double sum = 0;
        for(i=1;i<=n;i++) {
            int fu = (i&1)==1 ? 1 : -1;
            ji = ji*i;
            sum = sum + fu * (1d/ji);
        }
        System.out.printf("%.4f",sum);
        System.out.println();
    }







}