package com.algorithm.huawei;

import java.util.Scanner;

public class Huawei_chenfama {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weight = new int[n];
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            weight[i] = scanner.nextInt();
        }
        for(int j=0;j<n;j++){
            nums[j] = scanner.nextInt();
        }
        System.out.println(Weight(weight, nums));
        scanner.close();
    }


    public static int Weight(int[] weight,int[] nums){

        // 以为0也包括在内，所以即使没有砝码，也存在一种情况
        int total = 1;

        for(int i=0;i<weight.length;i++){
            total += weight[i]*nums[i];
        }

        // 声明一个标记数组，用于标记砝码可以组合出来的值
        boolean[] flag = new boolean[total];
        // 取第一种砝码，并对组合的重量进行标记
        for(int j=0;j<=nums[0];j++){
            flag[weight[0]*j] = true;
        }
        // 将这一种砝码标记完的各种组合之后，记录下重量
        total = weight[0]*nums[0];

        int sum = 0;
        // 从第二种砝码开始取
        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=nums[i];j++){
                for(int k=0;k<=total;k++){
                    sum = k + j*weight[i];
                    // 如果和大于标记数组长度则跳出当前循环
                    if(sum > flag.length-1){
                        break;
                    }
                    // 如果是第二种砝码重量的整数倍（不大于砝码的个数）直接标记，如果k位已标记加上0~n个砝码的重量未标记，则进行标记
                    if(flag[k] && !flag[sum] || k == 0){
                        flag[sum] = true;
                    }
                }
            }
            // 将本次放入一种砝码与之前的累加总和赋值给total
            total = sum;
        }
        // 对数组中值为true的进行统计
        int count = 0;
        for(int i=0;i<flag.length;i++){
            if(flag[i] == true){
                count++;
            }
        }
        return count;
    }
}
