package com.algorithm.leecode;

import java.util.HashSet;

// find the length of the longest consecutive elements sequence
public class Longest_consecutive_sequence {
    public static void main(String[] args) {
        int[] a = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(a));
    }


    public static int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        int i;
        int res = 0;
        for(i=0;i<num.length;i++) {
            set.add(num[i]);
        }
        for(i=0;i<num.length;i++) {
            if(set.remove(num[i])) {
                int down = num[i]-1;
                int up = num[i]+1;
                while(set.remove(down)) {
                    down--;   //以num[i]为对象向两边扩展
                }
                while(set.remove(up)) {
                    up++;
                }
                res = Math.max(res,up-down-1);
            }
        }
        return res;
    }
}