package com.company;

import java.math.BigInteger;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String haystack = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
        String needle = "babaaa";
        //String haystack = "lolash";
        long l = new BigInteger("0011",2);

        //String needle = "ash";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(final String haystack, final String needle) {
        if (haystack == null || needle == null){
            return -1;
        }
        if(needle.length() == 0){
            return -1;
        }
        for(int i = 0; i < haystack.length(); i++){
            if(i + needle.length() > haystack.length()){
                return -1; //not in string
            }
            int m = i;
            for(int j = 0; j < needle.length(); j++){
                if(needle.charAt(j) == haystack.charAt(m)){
                    if(j == needle.length()-1){
                        return i;
                    }
                    m++;
                }else{
                    break;
                }
            }
        }

        return -1;
    }
    //not functional
    public int strStrSemiFunctional(final String haystack, final String needle) {
        if(haystack == null && haystack.equals("")){
            return -1;
        }
        if(needle == null && needle.equals("")){
            return -1;
        }
        if(haystack.length() == 0 || needle.length() == 0){
            return -1;
        }else if(haystack.length() == 1 && needle.length() == 1){
            String hString = Character.toString(haystack.charAt(0));
            String nString = Character.toString(needle.charAt(0));
            if(hString.equals(nString)){
                return 0;
            }
        }else if(haystack.length() < needle.length()){
            return -1;
        }
        int sVal = 0;
        int wVal = needle.length()-1;
        for(int i = 0 ; i < haystack.length(); i++){
            String hString = Character.toString(haystack.charAt(i));
            String nString = Character.toString(needle.charAt(sVal));
            if(hString.equals(nString)){
                sVal++;
                if(sVal == wVal){
                    return i-sVal+1;
                }
            }else{
                sVal = 0;
            }
        }
        return -1;

    }


    public static int strStrBroken(final String haystack, final String needle) {

        Stack<Character> myStack = new Stack<Character>();
        int sVal = 0;
        for(int i = 0 ; i < haystack.length(); i++){
            String hString = Character.toString(haystack.charAt(i));
            String nString = Character.toString(needle.charAt(i));
            if(hString.equals(nString)){
                for(int j = 0; j < needle.length(); j++){
                    hString = Character.toString(haystack.charAt(j+i));
                    nString = Character.toString(needle.charAt(j));
                    if(hString.equals(nString)){
                        sVal++;
                        if(sVal == needle.length()){
                            return i;
                        }
                    }else if(!hString.equals(nString)){
                        sVal = 0;
                        i += j;
                        break;
                    }
                }
            }
        }
        return -1;

    }
}
