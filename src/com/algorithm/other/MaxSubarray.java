package com.algorithm.other;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class MaxSubarray {
	
	//最大递增序列的长度
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        int i;
        for(i=0;i<nums.length;i++)
        {
        	cur = Math.max(nums[i], cur+nums[i]);
        	res = Math.max(res, cur); 
        }
        return res;
    }
    
}
