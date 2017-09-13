package com.algorithm.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class QuickSort {
	public int mypartition(int[] arr, int low, int high)
	{
	    int pivot = arr[low];//选第一个元素作为枢纽元
	    while(low < high)
	    {
	        while(low < high && arr[high] >= pivot)high--;
	        if(low<high) {
	        	arr[low] = arr[high];//从后面开始找到第一个小于pivot的元素，放到low位置
	        	low++;
	        }
	        while(low < high && arr[low] < pivot)low++;
	        if(low<high) {
	        	arr[high] = arr[low];//从前面开始找到第一个大于pivot的元素，放到high位置
		        high--;
	        }
	    }
	    arr[low] = pivot;//最后枢纽元放到low的位置
	    return low;
	}

	public void quicksort(int[] arr, int low, int high)
	{
	    if(low < high)
	    {
	        int middle = mypartition(arr, low, high);
	        quicksort(arr, low, middle-1);
	        quicksort(arr, middle+1, high);
	    }
	}
	
}
