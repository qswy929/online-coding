package com.algorithm.sogou;

import java.util.Scanner;

//最长回文前缀
public class Sogou_hui_wen_qian_zhui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        int j = str.length() - 1;
        int end = j+1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
            } else {
                i = 0;
                end = j;
            }
            j--;
        }
        System.out.println(end);

    }
}
