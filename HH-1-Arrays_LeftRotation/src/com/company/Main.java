package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//HackerRank Problem - 2016-10-29
//https://www.hackerrank.com/challenges/ctci-array-left-rotation


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //int k = in.nextInt();
        int n = 5;
        int k = 4;
        int a[] = {1,2,3,4,5};


        //Generate Random Ints
        Random rand = new Random();
        //populate array
        /*
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = rand.nextInt(50);
        }*/

        //Develop Bruteforce approach
        System.out.println(n + " " + k);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nD Left Rotations: " + k);
        int copyArray[] = new int[n];
        for(int j = 0; j  < k ; j++) {
            if (k > 0 && n != 0) {
                for (int i = 0, start = 0; i < a.length; i++) {
                    if (i == 0)
                        start = a[i];//start holds first entry (start = 1)
                    if (i == a.length - 1) {
                        a[i] = start; //if index is 5-1=4.
                        break;
                    }
                    a[i] = a[i + 1];
                }
            }//end iff
        }
        //a = copyArray;
        System.out.println("\n Rotated");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }//end of main

}//end of class

//Hacker Rank Code:
/*
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //Develop Bruteforce approach
        for(int i = 0; i < k; i++){
            for(int j = 0, start = 0; j < a.length; j++){
                if(j == 0)
                    start = a[j];
                if(j == a.length - 1){
                    a[j] = start;
                    break;
                }
                a[j] = a[j+1];
            }//end-for-for
        }//end-for
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

 */
//Timed out in large test case, below works
/*

 */