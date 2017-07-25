package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int a = 15;
        int b = 9;
        int ans = uniquePaths(a,b);
        System.out.println(ans);

    }

    public static int uniquePaths(int a, int b){
        if(a <= 1 || b <= 1){
            return 1;
        }
        double m = a - 1;
        double n = b - 1;
        double numerator = factorial(m+n);
        double denom = factorial(m) * factorial(n);
        return (int)(numerator/denom);
        //factorial
    }

    public static double factorial(double num){
        if(num == 0){
            return 1;
        }else
            return (num * factorial(num-1));
    }
}
