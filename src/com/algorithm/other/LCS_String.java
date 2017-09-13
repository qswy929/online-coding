package com.algorithm.other;

public class LCS_String {

	int max;
	int a=0;
	int b=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int[][] LCS(String str1, String str2) {
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
					opt[i][j] = 0;
				}
				if(max<opt[i][j]) {
					max= opt[i][j];
					a=i;
					b=j;
				}
			}
		}
		return opt;
	}
	
	
	public void print(String x, String y){
		Object[] s = new Object[max+1];
		int k=max;
		int i=a-1;
		int j=b-1;
		s[k--]='\0';
		while(i>=0 && j>=0) {
			if(x.charAt(i)==y.charAt(j)) {
				s[k--]=x.charAt(i);
				i--;
				j--;				
			}
			else break;
		}		
		for(i=0;i<max;i++) {
			System.out.print(s[i]);
		}
	}

}
