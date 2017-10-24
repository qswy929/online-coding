package com.algorithm.other;


/*


对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。

给定一个整数数组A及它的大小n，请返回最短子数组的长度。
测试样例：

[1,5,3,4,2,6,7],7

返回：4


 */
public class Length_of_unsorted_array {

    public static void main(String[] args) {

    }

    public static int findShortest(int[] A, int n) {
        // write code here
        int max=A[0];   //从左往右，最大值，start记录比该值小的最靠右的位置
        int min=A[n-1]; //从右往左，最小值,end记录比该值大的最靠左的位置
        int start=0;
        int end=n-1;
        for(int i=0;i<n;i++){
            if(A[i]>=max){
                max=A[i];
            }else{
                start=i;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(A[i]<=min){
                min=A[i];
            }else{
                end=i;
            }
        }
        if(start==0&&end==n-1){  //原本就已排序
            return 0;
        }

        return Math.abs(start-end)+1;
    }


}