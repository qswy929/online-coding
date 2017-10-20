package com.algorithm.mogujie;

import java.util.Scanner;

/*
给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 */
public class Hui_wen_chuan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String alt1 = "";
            String alt2 = "";
            int i;
            for (i = 0; i <= (s.length() - 1) / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    alt1 = s.substring(0, i) + s.charAt(s.length() - 1 - i) + s.substring(i, s.length());
                    alt2 = s.substring(0, s.length() - i) + s.charAt(i) + s.substring(s.length() - i, s.length());
                    break;
                }
            }
            if (i > (s.length() - 1) / 2) {
                System.out.println("YES");
            } else {
                for (i = 0; i <= (alt1.length() - 1) / 2; i++) {
                    if (alt1.charAt(i) != alt1.charAt(alt1.length() - 1 - i)) {
                        break;
                    }
                }
                if (i > (alt1.length() - 1) / 2) {
                    System.out.println("YES");
                } else {
                    for (i = 0; i <= (alt2.length() - 1) / 2; i++) {
                        if (alt2.charAt(i) != alt2.charAt(alt2.length() - 1 - i)) {
                            break;
                        }
                    }
                    if (i > (alt2.length() - 1) / 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }

}