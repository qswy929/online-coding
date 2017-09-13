package com.algorithm.jingdong;
import java.util.*;

/**
 * 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。
 * 考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？
 */
public class tong_guo_kao_shi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        int[] poss = new int[n];
        for(i=0;i<n;i++) {
            poss[i] = sc.nextInt();
        }
        int m = (3*n+4)/5;
        exam(poss,m);
    }

    public static void exam(int[] poss,int m) {
        int n = poss.length;
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 1;
        int i,j;
        double sum = 0d;
        for(i=1;i<=n;i++) {
            dp[i][0] = dp[i-1][0]*(100d-poss[i-1])/100d;
            for(j=1;j<=i;j++) {
                dp[i][j] = dp[i-1][j]*(100d-poss[i-1])/100d + dp[i-1][j-1]*(poss[i-1]/100d);
                if(i==n && j>=m) {
                    sum += dp[i][j];
                }
            }
        }
        System.out.printf("%.5f",sum);
        System.out.println();
    }
}
