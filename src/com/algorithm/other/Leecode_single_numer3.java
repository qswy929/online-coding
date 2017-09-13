package com.algorithm.other;

/**
 * Created by Ethan on 2017/9/3.
 */
public class Leecode_single_numer3 {

    public static void main(String[] args) {
        int[] array = {2,3,4,4,5,6,5,3};
        int[] res = singleNumber(array);
        for(int in : res) {
            System.out.println(in);
        }
    }

    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int i;
        int diff = 0;
        for(i=0;i<nums.length;i++) {
            diff ^= nums[i];
        }
        diff &= -diff;
        for(i=0;i<nums.length;i++) {
            if((diff & nums[i]) == 0 ) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;

    }
}
