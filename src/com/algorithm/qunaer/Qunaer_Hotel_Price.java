package com.algorithm.qunaer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ethan on 2017/8/25.
 */
public class Qunaer_Hotel_Price {

    public static void main(String[] args) {
        List<Price> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            //System.out.println(str[1]);
            if(max<Integer.valueOf(str[1])) {
                max = Integer.valueOf(str[1]);
            }
            if(min>Integer.valueOf(str[0])) {
                min = Integer.valueOf(str[0]);
            }
            Price p  = new Price();
            p.start = Integer.valueOf(str[0]);
            p.end = Integer.valueOf(str[1]);
            p.price = Integer.valueOf(str[2]);
            list.add(p);
        }
        int[] prices = merge(list, max);
        System.out.println(print(prices, min));

    }

    public static int[] merge(List<Price> dateRangePrices ,int num) {
        int[] prices = new int[num+1];
        Arrays.fill(prices,-1);
        int i,j,start,end;
        for(i=0;i<dateRangePrices.size();i++) {
            start = dateRangePrices.get(i).start;
            end = dateRangePrices.get(i).end;
            for(j=start;j<=end;j++) {
                //System.out.println(i);
                prices[j] = dateRangePrices.get(i).price;
            }
        }
        return prices;
    }

    public static String print(int[] prices, int min) {
        int i;
        int start = min;
        int end = min;
        int price = prices[min];
        String res = "";
        for(i=0;i<prices.length;i++) {
            if(prices[i]!=-1) {
                if(prices[i]!=price) {
                    res = res + "[" + String.valueOf(start) + ", " + String.valueOf(end) + ", " + String.valueOf(price) + "],";
                    start = i;
                    price = prices[i];
                } else if(i==prices.length-1) {
                    res = res + "[" + String.valueOf(start) + ", " + String.valueOf(i) + ", " + String.valueOf(price) + "],";
                } else {
                    end = i;
                }
            }
        }
        return res.substring(0, res.length()-1);
    }
}

class Price {
    public int start;
    public int end;
    public int price;
}