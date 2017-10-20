package com.algorithm.baidu;

import java.util.Scanner;

// 第[n][m]位是n*m的乘法表中第k小的数
public class Chen_fa_biao {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k= sc.nextLong();
        int i;
        long mid;
        long left = 1;
        long right = n*m;
        while(left<=right) {
            mid = (left+right)/2;
            long count = 0;
            for(i=1;i<=n;i++) {
                count += mid>=(i*m) ? m : mid/i;
            }
            if(count<k) {  //<=mid 的数有count个
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        System.out.println(left);
    }

}