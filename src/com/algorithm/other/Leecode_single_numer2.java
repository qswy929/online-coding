package com.algorithm.other;

/**
 * Created by Ethan on 2017/9/3.
 */
public class Leecode_single_numer2 {

    public static void main(String[] args) {
        int[] array = {2,3,3,3,2,5,2};
        System.out.println(singleNumber(array));
    }

    public static int singleNumber(int[] nums) {
        int i,j;
        int sum = 0;
        for(i=0;i<32;i++) {
            int count = 0;
            for(j=0;j<nums.length;j++) {
                count += (nums[j] >> i) & 1;
            }
            sum += (count%3) << i;
        }
        return sum;
    }
}
