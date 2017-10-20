package com.algorithm.three60;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 内存管理
public class Nei_cun_guan_li {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            int maxMem = sc.nextInt();
            int i;
            int usedMem = 0;
            int handle = 1; // 初始句柄
            List<Memory> memList = new ArrayList<>();
            for(i=0;i<t;i++) {  // t行指令
                String action = sc.next();
                if(action.equals("new")) {
                    int newSize = sc.nextInt();  // new的size
                    String res;
                    System.out.println(res = newMem(memList, newSize, usedMem, maxMem, handle));
                    if(!res.equals("NULL")) {
                        usedMem += newSize;
                        handle++;  // 下一块内存空间的句柄
                    }
                } else if(action.equals("del")) {
                    int delHandle = sc.nextInt();  // del的句柄id
                    int freeSize = delMem(memList, delHandle, handle);
                    if(freeSize==-1) {
                        System.out.println("ILLEGAL_OPERATION");
                    } else {
                        usedMem -= freeSize;
                    }
                } else if(action.equals("def")) {
                    defMem(memList);
                }
            }

        }
    }

    public static String newMem (List<Memory> memoryList, int size, int usedMem, int maxMem, int handle) {
        if(size > maxMem - usedMem) {
            return "NULL";
        }
        if(memoryList.isEmpty()) {
            Memory m = new Memory(1, size, handle);
            memoryList.add(m);
            return String.valueOf(handle);
        }
        if(size < memoryList.get(0).start) {
            Memory m = new Memory(1, size, handle);
            memoryList.add(0, m);
            return String.valueOf(handle);
        }
        int i;
        for(i=0;i<memoryList.size()-1;i++) {
            int right = memoryList.get(i+1).start;
            int left = memoryList.get(i).end;
            if(right - left - 1 >= size) {
                Memory m = new Memory(left + 1 , left + size, handle);
                memoryList.add(i+1, m);
                return String.valueOf(handle);
            }
        }
        if(maxMem - memoryList.get(i).end >= size) {
            int left = memoryList.get(i).end;
            Memory m = new Memory(left + 1, left + size, handle);
            memoryList.add(m);
            return String.valueOf(handle);
        }
        return "NULL";
    }

    // 返回释放掉的内存空间大小
    public static int delMem(List<Memory> memoryList, int delHandle, int handle) {
        if(handle - 1 < delHandle) {
            return -1; // 无效句柄
        }
        int i;
        for(i=0;i<memoryList.size();i++) {
            Memory m = memoryList.get(i);
            if(m.handle==delHandle) {
                int freeSize = m.end - m.start + 1;
                memoryList.remove(i);
                return freeSize;
            }
        }
        return -1; // 无效句柄
    }

    public static void defMem(List<Memory> memoryList) {
        if(!memoryList.isEmpty()) {
            Memory m = memoryList.get(0);
            if(m.start != 1) {
                int diff = m.start - 1;
                m.start = 1;
                m.end -= diff;
            }
            int idx = m.end;
            int i;
            for(i=1;i<memoryList.size();i++) {
                m = memoryList.get(i);
                int diff = m.start - idx - 1;
                m.start = idx + 1;
                m.end -= diff;
                idx = m.end;
            }
        }

    }



}

class Memory {
    public int start;
    public int end;
    public int handle;
    public Memory(int start, int end, int handle) {
        this.start = start;
        this.end = end;
        this.handle = handle;
    }
}