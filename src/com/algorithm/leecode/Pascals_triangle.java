package com.algorithm.leecode;

import java.util.ArrayList;

/**
 * Created by Ethan on 2017/10/4.
 */
public class Pascals_triangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        int i,j;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(i=0;i<numRows;i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if(i==0) {
                list.add(1);
            } else if(i==1) {
                list.add(1);
                list.add(1);
            } else {
                for(j=0;j<=i;j++) {
                    if(j==0 || j==i) {
                        list.add(1);
                    } else {
                        list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
