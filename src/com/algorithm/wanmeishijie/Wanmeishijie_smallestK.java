package com.algorithm.wanmeishijie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//最小的k个数，按原顺序输出
public class Wanmeishijie_smallestK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] para = sc.nextLine().split(" ");
        int n = Integer.valueOf(para[0]);
        int k = Integer.valueOf(para[1]);
        int i;
        int[] array = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(i=0;i<n;i++) {
            array[i]=Integer.valueOf(sc.nextLine());
            map.put(array[i],i);
        }
        int[] copy = Arrays.copyOf(array,array.length);
        findK(array,k);
        int[] val = new int[k];
        for(i=0;i<k;i++) {
            val[i] = map.get(array[i]);
        }
        Arrays.sort(val);
        for(i=0;i<k;i++) {
            System.out.println(copy[val[i]]);
        }
    }

    public static void findK(int[] array,int k) {
        int l = 0;
        int r = array.length-1;
        int idx = 0;
        if(l<r) {
            idx = partition(array,l,r);
        }
        while(idx != k-1) {
            if(idx < k-1) {
                l = idx + 1;
                idx = partition(array, l, r);
            } else {
                r = idx - 1;
                idx = partition(array, l, r);
            }
        }
    }

    public static int partition(int[] array,int start,int end) {
        int l = start;
        int r = end;
        int pivot = array[l];
        while(l<r) {
            while(l<r && array[r]>=pivot) {
                r--;
            }
            if(l<r) {
                array[l++] = array[r];
            }
            while(l<r && array[l]<pivot) {
                l++;
            }
            if(l<r) {
                array[r--] = array[l];
            }
        }
        array[l] = pivot;
        return l;
    }
}
