package com.company;

public class Main{
    public static int numSetBitss(long a) {
        int count = 0;
        while(a > 0){
            if(a % 2 == 1)
                count++;

            a = a/2;
        }
        return count;
    }

    public static int numSetBits(long A) {

        int count = 0;

        while (A > 0) {
            if ( (A & 1) != 0)
                count++;
            A >>= 1;
        }

        return count;

    }


    public static void main(String[] args){
        long a = 43;
        //System.out.println(numSetBits(a));
        int num = 8;
        int num2 = 8;
        int var = num&num2;
        System.out.println(var);
    }
}