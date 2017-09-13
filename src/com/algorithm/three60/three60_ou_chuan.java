package com.algorithm.three60;

import java.util.HashMap;
import java.util.Scanner;

public class three60_ou_chuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(even(str));
    }

    public static int even(String str) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] g = new int[str.length()+1];
        g[0] = 0;
        map.put(g[0],1);
        int i;
        int sum = 0;
        for(i=0;i<str.length();i++) {
            int num = str.charAt(i) - 'a';
            g[i+1] = g[i] ^ (1<<num);
            if(map.containsKey(g[i+1])) {
                sum += map.get(g[i+1]);
                map.put(g[i+1],map.get(g[i+1])+1);
            } else {
                map.put(g[i+1],1);
            }
        }
        return sum;
    }
}
