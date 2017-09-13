package com.algorithm.other;

/**
 * Created by Ethan on 2017/8/25.
 */
public class KMP {

    public static void main(String[] args) {
        String ori = "acdsgerbegedhtk";
        String find = "ed";
        int[] next = getNext(find);
        for (int a : next) {
            System.out.print(a+" ");
        }
        System.out.println();
        search(ori, find, next);
    }

    public static void search(String original, String find, int next[]) {
        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != find.charAt(j))
                j = next[j];
            if (original.charAt(i) == find.charAt(j))
                j++;
            if (j == find.length()) {
                System.out.println("find at position " + (i - j + 1));
                System.out.println(original.subSequence(i - j + 1, i + 1));
                j = next[j];
            }
        }
    }

    // 构造next数组
    public static int[] getNext(String find)
    {
        int len=find.length();
        int j=0;

        int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
        next[0]=next[1]=0;

        for(int i=1;i<len;i++)//i表示字符串的下标，从0开始
        {  //j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
            while(j>0&&find.charAt(i)!=find.charAt(j))  j=next[j];
            if(find.charAt(i)==find.charAt(j))  j++;
            next[i+1]=j;
        }

        return next;
    }
}
