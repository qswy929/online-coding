package com.algorithm.leecode;

import java.math.BigInteger;

// 两个二进制数相加，结果也显示为二进制
public class Add_binary {
    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        System.out.println(addBinary("11","1"));
    }

    public static String addBinary(String a, String b) {
        BigInteger aa = new BigInteger(a,2);
        BigInteger bb = new BigInteger(b,2);
        return aa.add(bb).toString(2);
    }

}