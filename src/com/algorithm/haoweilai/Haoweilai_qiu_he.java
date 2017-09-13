package com.algorithm.haoweilai;

import java.util.ArrayList;
import java.util.Scanner;

//求和：输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m,
// 要求将其中所有的可能组合列出来（按字典序）
public class Haoweilai_qiu_he {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,m,i;
        while(sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            getSum(1, m, n);
            for(ArrayList<Integer> l : res) {
                for(i = 0; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    public static void getSum(int index, int count, int n) {
        if(count == 0) {
            res.add(new ArrayList<>(list));
        }
        else {
            for(int i = index; i <= count && i <= n; i++) {
                list.add(i);
                getSum(i + 1, count - i, n);
                list.remove(list.size() - 1);
            }
        }
    }

}

