package com.algorithm.xiecheng;

import java.util.Scanner;

//第一个仅出现一次的数组元素
public class Array_element_search {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int i;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(i=0;i<input.length;i++) {
            int d = Integer.valueOf(input[i]);
            if(d>max) {
                max = d;
            }
            if(d<min) {
                min = d;
            }
        }
        int[] count = new int[max-min+1];
        for(i=0;i<input.length;i++) {
            int d = Integer.valueOf(input[i]);
            count[d-min]++;
        }
        for(i=0;i<count.length;i++) {
            if(count[i]==1) {
                System.out.println(i+min);
                break;
            }
        }
    }
}