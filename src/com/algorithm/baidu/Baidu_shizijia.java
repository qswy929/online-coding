package com.algorithm.baidu;

import java.util.*;

//百度：十字架
public class Baidu_shizijia {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        int i,j;
        //int[] groups = new int[group];
        for(i=0;i<group;i++) {
            char[][] array = new char[1][1];
            array[0][0] = 'o';
            int cur = sc.nextInt();
            if(cur==1) {
                System.out.println("Case #"+(i+1)+":");
                print(array);
            } else {
                System.out.println("Case #"+(i+1)+":");
                for(j=1;j<cur;j++) {
                    array = fillArray(array);
                }
                print(array);
            }
        }
    }

    public static char[][] fillArray(char[][] a) {
        int sizeA = a.length;
        char[][] b = new char[sizeA*3][sizeA*3];
        int i,j,k;
        for(j=0;j<sizeA*3;j++) {
            Arrays.fill(b[j],' ');
        }
        for(i=0;i<sizeA;i++) {
            for(j=sizeA;j<2*sizeA;j++) {
                b[i][j] = a[i][j-sizeA];
            }
        }
        for(i=0;i<3;i++) {
            for(j=sizeA;j<2*sizeA;j++) {
                for(k=sizeA*i;k<sizeA*i+sizeA;k++){
                    b[j][k] = a[j-sizeA][k-i*sizeA];
                }
            }
        }
        for(i=2*sizeA;i<3*sizeA;i++) {
            for(j=sizeA;j<2*sizeA;j++) {
                b[i][j] = a[i-2*sizeA][j-sizeA];
            }
        }
        return b;
    }

    public static void print(char[][] c) {
        int size = c.length;
        int i,j;
        for(i=0;i<size;i++) {
            for(j=0;j<size;j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }
}
