package com.algorithm.leecode;

import java.util.ArrayList;

public class Two_sum {
    public static void main(String args[]) {

    }

    // array已按升序排列
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);
        if(array.length==0) {
            return list;
        }
        //Arrays.sort(array);
        int left = 0;
        int right = array.length-1;
        int min = Integer.MAX_VALUE;
        int a = array[left];
        int b = array[right];
        while(left < right) {
            if(array[left] + array[right] < sum) {
                left++;
            } else if(array[left] + array[right] > sum) {
                right--;
            } else {
                if(array[left]*array[right] < min) {
                    a = array[left];
                    b = array[right];
                    min = a * b;
                }
                left++;
                right--;
            }
        }
        if(min!=Integer.MAX_VALUE) {
            list.add(Math.min(a, b));
            list.add(Math.max(a, b));
        }
        return list;
    }
}