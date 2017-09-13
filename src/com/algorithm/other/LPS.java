package com.algorithm.other;

public class LPS {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("dasdwqqwcdqw"));
    }

    //最长回文串
    public static String helper(String s,int begin, int end)
	{
		while (begin >= 0 && end <= s.length() - 1  
                && s.charAt(begin) == s.charAt(end)) {  
            begin--;  
            end++;  
        }  
        String subS = s.substring(begin+1, end);  
        return subS;  
    }  
	
	
	public static String longestPalindrome(String s) {
       int i;     
       if(s.length()<=1)
       {
    	   return s;
       }
       String res = s.substring(0, 1);
       for(i=0;i<s.length();i++)
       {
    	   String tmp = helper(s, i, i);
    	   if(tmp.length()>res.length())
    	   {
    		   res= tmp;
    	   }
    	   tmp = helper(s, i, i+1);
    	   if(tmp.length()>res.length())
    	   {
    		   res= tmp;
    	   }   	   
       }
       return res;
    }
}
