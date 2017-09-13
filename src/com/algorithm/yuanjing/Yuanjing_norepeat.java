package com.algorithm.yuanjing;

import java.util.Arrays;
import java.util.Scanner;

public class Yuanjing_norepeat {
	
	
    // 第一个无重复的字符
    int index=0;
	int[] cIndexes = new int[256];
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	}
	
	
	public void init() {
		int i;
		for(i=0;i<cIndexes.length;i++) {
			cIndexes[i]=-1;
		}
	}

  //return the first appearence once char in current stringstream
  
    
    public void insert(char a){
      if(cIndexes[a]==-1){
        cIndexes[a]=index;
      }
      else if(cIndexes[a]>=0){
       cIndexes[a]=-2;
      }
      index++;
   }
    
    
    public char FirstAppearingOnce() {
        int local= Integer.MAX_VALUE;
        char value='#';
        for(int i=0;i<cIndexes.length;i++){
        	if(cIndexes[i]>=0 && cIndexes[i]<local){
        		local= cIndexes[i];
        		value=(char)i;
            }
        }
        return value;
    }
    
    
}

