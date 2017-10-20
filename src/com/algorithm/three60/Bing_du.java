package com.algorithm.three60;

import java.util.Scanner;

// 1-n的n个自然数中有多少个是只由0和1组成
public class Bing_du {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(Integer.parseInt(fenShen(sc.nextLine()),2));
        }
    }

    public static String fenShen(String digit) {
        int i;
        String res = "";
        boolean flag = false;
        for(i=0;i<digit.length();i++) {
            int d = digit.charAt(i) - '0';
            if(d>1) {
                res += "1";
                flag = true;
            } else if (d==0 && flag) {
                res += "1";
            } else {
                res += digit.charAt(i);
            }
        }
        return res;
    }
}