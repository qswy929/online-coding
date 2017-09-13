package com.algorithm.other;

import java.util.Scanner;

/**
 * Created by Ethan on 2017/9/3.
 */
public class WithoutKMP {
    //查找子串的位置
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String sub_str = sc.nextLine();
        System.out.println(sub(str,sub_str));

    }

    public static int sub(String str, String sub_str) {
        int i = 0;
        int j = 0;
        int next = -1;
        while(i<str.length() && j< sub_str.length()) {
            if(str.charAt(i)!=sub_str.charAt(j)) {
                j = 0;
                next++;
                i = next + 1;
            }
            else {
                //next = i;
                i++;
                j++;
            }

        }
        if(j==sub_str.length()) {
            return next + 1;
        }
        return -1;
    }
}
