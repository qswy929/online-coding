package com.algorithm.jinritoutiao;

import java.util.*;

// 1-n按字典序排序，第m个数
public class Zi_dian_shu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long n =sc.nextLong();
            long m =sc.nextLong();

            long i = 1;//从1开始数
            m--;
            while(m!=0) {
                long num = 0;
                long start = i,end = i+1;
                while(start<=n){
                    num += Math.min(n+1,end)-start;
                    start*=10;
                    end*=10;
                }
                if(num>m) {
                    i *= 10;
                    m--;
                } else{
                    m-=num;
                    i++;
                }
            }
            System.out.println(i);
        }
    }
}
