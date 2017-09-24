package com.algorithm.leecode;

import java.util.ArrayList;

// 使字符串的所有子串都是回文串的分割方法
public class Palindrome_partitioning {
    public static void main(String[] args) {
       String s = "aab";
       partition(s);
    }

    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> alist = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        huiwen(alist,s,0,list);
        //System.out.println(alist.size());
        int i,j;
        for(i=0;i<alist.size();i++) {
            for(j=0;j<alist.get(i).size();j++) {
                System.out.print(alist.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return alist;
    }


    public static void huiwen(ArrayList<ArrayList<String>> alist, String s, int begin,ArrayList<String> list) {
        if(begin==s.length()) {
            ArrayList<String> t = new ArrayList<>(list);
            alist.add(t);
        } else {
            int i;
            for(i=begin+1;i<=s.length();i++) {
                String tmp = s.substring(begin,i);
                //System.out.println(begin +" "+i);
                if(isHuiwen(tmp)) {
                    list.add(tmp);
                    huiwen(alist,s,i,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static boolean isHuiwen(String s) {
        if(s.length()==1) {
            return true;
        }
        int end = s.length()%2==0 ? (s.length()-1)/2 : s.length()/2;
        int i;
        for(i=0;i<=end;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

}