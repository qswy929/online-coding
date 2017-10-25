package com.algorithm.meituan;


/*

在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。

给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
测试样例：

[10,22,5,75,65,80],6

返回：87

 */


public class Stock_trading {

    public static void main(String[] args) {
        int[] array = {10,22,5,75,65,80};
        System.out.println(maxProfit(array,array.length));
    }

    public static int maxProfit(int[] prices, int n) {
        // write code here
        int i;
        int maxSum = 0;
        for(i=-1;i<n-1;i++) {
            int left = maxGain(prices,0,i);
            int right = maxGain(prices,i+1,n-1);
            //System.out.println(left +"+"+right);
            maxSum = Math.max(maxSum,left+right);
        }
        return maxSum;
    }

    // array[l,r]中收益的最大值
    public static int maxGain(int[] array, int l,int r) {
        if(r-l<1) {
            return 0;
        }
        int max = 0;
        int curMin = array[l];
        int i;
        for(i=l+1;i<=r;i++) {
            int val = array[i]-curMin;
            max = Math.max(max,val);
            curMin = Math.min(curMin,array[i]);
        }
        return max;
    }

}