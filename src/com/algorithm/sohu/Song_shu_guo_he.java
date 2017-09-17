package com.algorithm.sohu;

import java.util.Arrays;
import java.util.Scanner;

//搜狐：袋鼠过河
public class Song_shu_guo_he {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jump = new int[n];
        int i;
        for(i=0;i<n;i++) {
            jump[i]=sc.nextInt();
        }
        jumpTimes(jump);
    }

    public static void jumpTimes(int[] jump) {
        /*定义一个数组用来记录每到第几米所需要的最少条次数,因为包含0米，
        而河的宽度是a要跳到第a米，所以需要数组长度为a+1
        */
        int[] dp = new int[jump.length+1];
        int i,j;
        Arrays.fill(dp,1000000);
        dp[0]=0;
        for(i=1;i<dp.length;i++) {
            for(j=i-1;j>=0;j--) {
                if(jump[j]!=0) {
                    if(jump[j]+j >= i) {
                        dp[i] =  Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }
        System.out.println((dp[dp.length-1]==1000001 || dp[dp.length-1]==1000000) ? -1 : dp[dp.length-1]);
    }




}