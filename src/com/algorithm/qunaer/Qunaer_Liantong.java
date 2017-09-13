package com.algorithm.qunaer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Created by Ethan on 2017/8/25.
 */
public class Qunaer_Liantong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int n = strs.length;
            int num[] = new int[n];
            Queue<Integer> q = new LinkedList<Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(strs[i], 16);
                list.add(num[i]);
            }
            //类似图的广度优先遍历
            q.offer(num[0]);
            list.remove(Integer.valueOf(num[0]));
            while (!q.isEmpty()) {
                int temp = q.poll();
                if (list.contains(temp + 1)) {
                    q.offer(temp + 1);
                    list.remove(Integer.valueOf(temp + 1));
                }
                if (list.contains(temp - 1)) {
                    q.offer(temp - 1);
                    list.remove(Integer.valueOf(temp - 1));
                }
                if (list.contains(temp + 4)) {
                    q.offer(temp + 4);
                    list.remove(Integer.valueOf(temp + 4));
                }
                if (list.contains(temp - 4)) {
                    q.offer(temp - 4);
                    list.remove(Integer.valueOf(temp - 4));
                }
            }
            if (list.isEmpty())
                System.out.println("pong");
            else
                System.out.println("pang");
        }
    }
}