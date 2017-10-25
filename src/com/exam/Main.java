package com.exam;


import java.util.*;

/*

有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。

给定一个二位数组arr及题目中的参数n，请返回结果数组。
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4

返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */

public class Main {

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] res = arrayPrint(a,a.length);
        for(int i : res) {
            System.out.println(i);
        }
    }

    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        for(i=n-1;i>=0;i--) {
            int zero = 0;
            int j = i;
            while(j<n) {
                list.add(arr[zero][j]);
                zero++;
                j++;
            }
        }
        for(i=1;i<n;i++) {
            int zero = 0;
            int j = i;
            while(j<n) {
                list.add(arr[j][zero]);
                zero++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        for(i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}