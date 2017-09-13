package com.algorithm.other;

public class LCS_xulie {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] opt = LCS("rhkdfd","ckde");
        
         int i,j;
         for(i=0;i<opt.length;i++) {
        	 for(j=0;j<opt[i].length;j++) {
        		 System.out.print(opt[i][j]+" ");
        	 }
        	 System.out.println();
         }
         print(opt,"rhkdfd","ckde",6,4);
	}
	
	
	
	public static int[][] LCS(String str1, String str2) {
		int[][] opt = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 0; i <= str1.length(); i++) {
			opt[i][0] = 0;
		}
		
		for (int j = 0; j <= str2.length(); j++) {
			opt[0][j] = 0;
		}
		
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					opt[i][j] = opt[i-1][j-1] + 1;
				} else {
					opt[i][j] = ( opt[i-1][j] >= opt[i][j-1] ? opt[i-1][j] : opt[i][j-1]);
				}
			}
		}
		
		return opt;
	}
	
	public static void print(int[][] opt, String X, String Y, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}	
		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			print(opt, X, Y, i - 1, j - 1); 
			System.out.print(X.charAt(i - 1));	
        }else if (opt[i - 1][j] >= opt[i][j-1]) {
            print(opt, X, Y, i - 1, j);
        } else {
            print(opt, X, Y, i, j - 1);}
   }
}
