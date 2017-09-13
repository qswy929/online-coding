package com.algorithm.three60;

import java.util.Arrays;
import java.util.Scanner;

/*希望得到不出现重复颜色的气球串，
        那么现在小明需要将这个气球串剪成多个较短的气球串，小明一共有多少种剪法？*/
public class jian_qi_qiu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int i;
            int[] balloon = new int[n];
            for(i=0;i<n;i++) {
                balloon[i]=sc.nextInt();
            }
            System.out.println(qiqiu(balloon));
        }
    }

    public static int qiqiu(int[] balloon) {
        int mod = 1000000007;
        int[] count = new int[10];
        int[] dp =  new int[balloon.length];
        dp[0] = 1;
        int i,j;
        for(i=1;i<balloon.length;i++) {
            Arrays.fill(count,0);
            for(j=0;j<=i;j++) {
                count[balloon[i-j]]++;
                if(count[balloon[i-j]]>1) {
                    break;
                }
                if(i-j-1==-1) {
                    dp[i] = (dp[i] + 1) % mod;
                } else {
                    dp[i] = (dp[i] + dp[i-j-1]) % mod;
                }

            }
        }
        return dp[balloon.length-1];
    }
}