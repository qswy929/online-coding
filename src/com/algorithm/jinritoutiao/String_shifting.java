package com.algorithm.jinritoutiao;

import java.util.Scanner;

// shift过程中满足 shift(string, x) = string (0＜= x ＜n)。
public class String_shifting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cArray = str.toCharArray();
        int radix = 53; //进制基数
        int i;
        long tmp;
        long pre = 0;
        long num = 1;
        int count = 1;
        for(i=0;i<cArray.length;i++) {
           pre = pre*radix + change(cArray[i]);
           num *= radix;
        }
        tmp = pre;
        for(i=0;i<cArray.length-1;i++) {
            pre = pre*radix + change(cArray[i]) - num*change(cArray[i]);
            if(tmp==pre) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int change(char c) {
        if(c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return 26 + c - 'a';
    }


}