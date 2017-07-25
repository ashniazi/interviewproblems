package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "abbxddx";
        System.out.println("Longest Palindromic Substring : " + longestPali(input));

    }

    public static String longestPali(String a){
            int n = a.length();
            if(n <= 1)
                return a;
            int start = 0;
            int maxLen = 0;
            int j;
            int k;
            for(int i = 1; i < n; i++){
                j = i-1; //left 0
                k = i+1; //right
                while(k < n && a.charAt(k) == a.charAt(i)) // check if
                    k++;
                while(j >= 0 && a.charAt(j) == a.charAt(i))
                    j--;
                while(j >= 0 && k < n && a.charAt(j) == a.charAt(k)){
                    j--;
                    k++;
                }
                if(k - j - 1 > maxLen){
                    maxLen = k - j - 1;
                    start = j + 1;
                }
            }
            if(maxLen == 1)
                return a.substring(0, 1);
            return a.substring(start, start + maxLen);
        }

    public static String longestPalindrome(String a) {
        StringBuilder S = new StringBuilder();
        StringBuilder Sr = new StringBuilder();

        S.append(a);
        Sr.append(a);
        Sr.reverse();
        ArrayList<Integer> indexArr = new ArrayList<Integer>();
        for(int i = 0; i < a.length(); i++){
            int v1 = (int) S.charAt(i);
            int v2 = (int) Sr.charAt(i);
            if(v1 - v2 == 0){
                indexArr.add(0); //same
            }else{
                indexArr.add(1); //not same
            }
        }
        String curLargest = "";
        for(int i = 0, j = 0; i < a.length(); i++){
            while(j < a.length()){
                if(indexArr.get(j) == 0){
                    j++;
                    if(j > 0) {
                        String temp = S.substring(i, j); //stores the common string
                        if (checkIfPali(temp)) {
                            if (temp.length() > curLargest.length()) {
                                curLargest = temp;
                            }
                        }
                    }
                }else{
                    j++;
                    i = j;
                    break;
                }
            }
        }
        return curLargest;
    }
    public static boolean checkIfPali(String s){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(s);
        sb1.append(s);
        sb1.reverse();
        if(sb.toString().equals(sb1.toString())){
            return true;
        }
        return false;
    }
}
