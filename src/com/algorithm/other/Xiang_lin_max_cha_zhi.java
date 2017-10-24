package com.algorithm.other;


import java.util.ArrayList;
import java.util.List;


/*

请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。

给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
测试样例：

[9,3,1,10],4

返回：6

 */

public class Xiang_lin_max_cha_zhi {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int[] A = {9,3,1,10};
        System.out.println(findMaxDivision(A,A.length));
    }

    // 桶排序
    public static int findMaxDivision(int[] A, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i;
        for(i=0;i<n;i++) {
            if(A[i] > max) {
                max = A[i];
            }
            if(A[i] < min) {
                min = A[i];
            }
        }
        if(max==min) {
            return 0;
        }
        int[] bucket = new int[max-min+1];
        for(i=0;i<n;i++) {
            bucket[A[i]-min] ++;
        }
        List<Integer> list = new ArrayList<>();
        for(i=0;i<bucket.length;i++) {
            if(bucket[i]>0) {
                list.add(i);
            }
        }
        max = Integer.MIN_VALUE;
        for(i=1;i<list.size();i++) {
            int diff = list.get(i)-list.get(i-1);
            if(diff > max) {
                max = diff;
            }
        }
        return max;
    }



}