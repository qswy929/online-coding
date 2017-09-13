package com.algorithm.didi;

import java.util.Scanner;

//滴滴：数组中数字和为sum的方法数
public class Didi_equal_sum_method {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int i;
        int[] num = new int[n];
        for(i=0;i<n;i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(dp(sum,num));
    }


    //建立一个长度为sum+1的数组，数组表示当前这个数有多少种组合方式
    public static long dp(int sum,int[] c){
        long[] nums = new long[sum+1];
        for(int i : c){
            if(i<=sum) {
                for(int j = sum;j>=1;j--){
                    if(nums[j]>0&&j+i<=sum)
                        nums[j+i] += nums[j];
                }
                nums[i]++;
            }
        }
        return nums[sum];
    }
}
