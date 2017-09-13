package com.algorithm.meituan;

import java.util.Scanner;

public class Meituan_miane {
    //面额有多少种组成方式
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] coin = {1,5,10,20,50,100};
        long f[][] = new long[coin.length][target+1];
        int i,j,k;
        for(i=0;i<=target;i++) {
            f[0][i] = 1;
        }
        for(i=0;i<coin.length;i++) {
            f[i][0] = 1;
        }
        for(i=1;i<coin.length;i++) {  //i种硬币
            for(j=1;j<=target;j++) {   //j元钱
                for(k=0;k<=j/coin[i];k++) {  //j元钱时第i种面值（最大的面值）最多用几张
                    f[i][j] += f[i-1][j-k*coin[i]];
                }
            }
        }
        System.out.println(f[coin.length-1][target]);
    }
}
