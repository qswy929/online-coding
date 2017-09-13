package com.algorithm.tencent;

import java.util.Scanner;

//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//输出需要删除的字符个数
public class gou_zao_hui_wen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
             String str1 = sc.nextLine();
             String str2 = new StringBuffer(str1).reverse().toString();
             System.out.println(LCS(str1,str2));
        }
    }

    public static int LCS(String str1, String str2) {
        int[][] opt = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = Integer.MIN_VALUE;
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
                if(opt[i][j]>maxLen) {
                    maxLen = opt[i][j];
                }
            }
        }

        return str1.length()-maxLen;
    }

}

