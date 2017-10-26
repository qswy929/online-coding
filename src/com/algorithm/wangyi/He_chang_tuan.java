package com.algorithm.wangyi;

import java.util.*;

/*

有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，
使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，
包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

输出描述:

输出一行表示最大的乘积。

示例1
输入

3
7 4 7
2 50


 */

public class He_chang_tuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int i;
            int[] a = new int[n];
            for (i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(computeMaxProduct(a, k, d));
        }
    }

    private static long computeMaxProduct(int[] array, int k, int d) {
        long dpMax[][] = new long[array.length][k + 1];
        long dpMin[][] = new long[array.length][k + 1];
        // dpMax[i][j] 表示以数组元素A[i]作结尾时， 序列长度为j的最大乘积结果
        for (int i = 0; i < array.length; i++) {
            dpMax[i][1] = array[i];
            dpMax[i][0] = array[0];
        }

        // 状态转移方程是 dpMax[i][j] = max(dpMax[i-1][j-1]* A[i], dpMin[i-d][j-1]* A[i])
        long maxSoFar = Long.MIN_VALUE;
        for (int j = 2; j <= k; j++) {
            for (int i = j - 1; i < array.length; i++) {
                dpMax[i][j] = Long.MIN_VALUE;
                dpMin[i][j] = Long.MAX_VALUE;
                for (int x = 1; x <= d && (i - x) >= j - 2; x++) {
                    // 倒数第二个元素自己加上之前的元素数量至少还要有j-1个， 所以下标i-x需呀大于j-2
                    long resMax = Math.max(dpMax[i - x][j - 1] * array[i], dpMin[i - x][j - 1] * array[i]);
                    long resMin = Math.min(dpMax[i - x][j - 1] * array[i], dpMin[i - x][j - 1] * array[i]);
                    if (resMax > dpMax[i][j])
                        dpMax[i][j] = resMax;
                    if (resMin < dpMin[i][j])
                        dpMin[i][j] = resMin;
                }
            }
        }

        for (int i = k - 1; i < array.length; i++) {
            if (dpMax[i][k] > maxSoFar) {
                maxSoFar = dpMax[i][k];
            }
        }
        return maxSoFar;
    }
}