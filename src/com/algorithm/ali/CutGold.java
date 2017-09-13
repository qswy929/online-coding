package com.algorithm.ali;

import java.util.PriorityQueue;

public class CutGold {

	
	public int cut(int[] parts) {
		if(parts.length==0||parts.length==1) return 0; 
        if(parts.length==2) return parts[0]+parts[1]; 
        //小的在队头 每次取出最小的 
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<parts.length;i++){
          queue.add(parts[i]);
        } 
        int ans=0;
        while (!queue.isEmpty()) {
          Integer leftVal=queue.poll();
          Integer rightVal=queue.poll();
          if(rightVal==null){ 
        	  break;
          } 
          int sum=leftVal+rightVal;
          ans+=sum;
          queue.add(sum);
        }
        return ans; 
    }
}
