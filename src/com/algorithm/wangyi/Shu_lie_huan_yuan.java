package com.algorithm.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/*
牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，
其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，
顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 */

public class Shu_lie_huan_yuan {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        boolean[] flag = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>(100);
        int i;
        for(i=0;i<n;i++) {
            array[i] = sc.nextInt();
            if(array[i]!=0) {
                flag[array[i]-1] = true;
            }
        }
        if(n==1) {
            System.out.println(0);
            return;
        }
        for(i=0;i<n;i++) {
            if(!flag[i]) {
                list.add(i+1);
            }
        }

        arrange(array,list,0,list.size(),k);
        System.out.println(sum);
    }

    public static void paiLie(int[] array, ArrayList<Integer> list, int k) {
        int i;
        int j = 0;
        for(i=1;i<array.length;i++) {
            if (array[i - 1] == 0) {
                array[i - 1] = list.get(j);
                j++;
            }
            if (array[i] == 0) {
                array[i] = list.get(j);
                j++;
            }
        }
        if(niXuDui(array)==k) {
            sum++;
        }
    }


    public static int niXuDui(int[] array) {
        int i,j;
        int count = 0;
        for(i=1;i<array.length;i++) {
            for(j=0;j<i;j++) {
                if(array[j] < array [i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void swap(ArrayList<Integer> list, int i, int j)
    {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    public static void arrange (int[] array, ArrayList<Integer> list, int st, int len, int k)
    {
        if (st == len - 1)
        {
            int[] tmp = array.clone();
            paiLie(tmp,list,k);
        }
        else
        {
            for (int i = st; i < len; i++)
            {
                swap(list, st, i);
                arrange(array, list, st + 1, len, k);
                swap(list, st, i);
            }
        }

    }
}