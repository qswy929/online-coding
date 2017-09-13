package com.algorithm.xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

//有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
public class Xiecheng_chen_ji_zui_da {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(maxMultiply(n));
    }

    public static long maxMultiply(int n) {
        int i = 2;
        ArrayList<Integer> list = new ArrayList<>();
        while(n-i>=0) {
            list.add(i);
            n -= i;
            i++;
        }
        for(i=0;i<n;i++) {
            int idx = list.size()-1-i;
            if(idx<0) {
                idx += list.size();
            }
            list.set(idx,list.get(idx)+1);
        }
        long res = 1;
        for(i=0;i<list.size();i++) {
            res *= list.get(i);
        }
        return res;
    }
}