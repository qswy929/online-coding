package com.algorithm.other;

/**
 * Created by Ethan on 2017/8/31.
 */
public class Yuesefu_circle {

    public static void main(String[] args) {
        System.out.println(circle(4,2));
    }

    //0到n-1一共n个人，按顺时针从0开始报数，报到m–1的人退出圆形队列
    public static int circle(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++)
        {
            last = (last + m) % i;
        }
        return last;
    }
}
