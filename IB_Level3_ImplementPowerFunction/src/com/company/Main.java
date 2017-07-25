package com.company;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Answer is :" + pow(71045970,41535484,64735492));
    }

    public static int pow(int x, int n, int d){
        long a = x;
        long res = 1L;

        while( n > 0){
            if(n%2 == 1){
                //odd
                res *= a;
                res %= d;
            }
            a *= a;
            a %= d;
            n = n >> 1;
        }
        res = (res + d) %d;
        return (int) res;
    }

    public static int powOLD(int x, int n, int d){
        boolean flag = false;
        if(x < 0){
            flag = true;
        }
        double val, remainder;
        if(flag){
            val = power(-x,n);
            remainder = val%d;
            return (int)d-(int)remainder;
        }else{
            val = power(x,n);
            remainder = val%d;
            return (int) remainder;
        }
    }
    public static double power(int x, int n){
        if(n == 0)
            return 1;
        return x * power(x, --n);
    }
}
