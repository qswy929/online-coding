package com.algorithm.leecode;

import java.util.*;

//candy:rating高的人要比其邻居拿到的糖果多，每人至少一颗糖果。求最少需要的糖果数
public class Candy{
    public static void main(String[] args) {
        int[] val = {4,2,1,3};
        System.out.println(candy(val));
    }

    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        int i;
        int sum = 0;
        for(i=1;i<ratings.length;i++) {
            candies[i] = ratings[i-1] < ratings[i] ? candies[i-1] + 1 : 1;
        }
        for(i=ratings.length-2;i>=0;i--) {
            candies[i] = ratings[i] > ratings[i+1] ? Math.max(candies[i],candies[i+1] + 1) : candies[i];
            sum += candies[i];
        }
        return sum + candies[ratings.length-1];
    }
}
