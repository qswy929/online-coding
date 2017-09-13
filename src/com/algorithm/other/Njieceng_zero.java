package com.algorithm.other;

//n阶层末尾有多少个0
public class Njieceng_zero {
    int fun(int n)
    {
        int num = 0;

        while(n>0)
        {
            num += n / 5;
            n = n / 5;
        }

        return num;
    }
}
