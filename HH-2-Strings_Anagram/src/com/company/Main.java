package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {
    public static int numberNeeded(String first, String second) {
        int count = 0;
        int[] freq = new int[26]; //letters in the alphabet
        System.out.println(Arrays.toString(first.toCharArray()));

        for(char c : first.toCharArray()) {
            System.out.println(c);
            freq[c - 'a'] += 1 ;
        }
        System.out.println(Arrays.toString(freq));
        for(char c : second.toCharArray())
            freq[c - 'a']--;
        System.out.println(Arrays.toString(freq));
        for(int i : freq)
            count += Math.abs(i);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String a = in.next();
        //String b = in.next();
        String a = "cxdem";
        String b = "abcxn";
        //System.out.println(b.length());
        System.out.println(numberNeeded(a, b));
    }
}

/*
Imperfect Solution:
public static int numberNeeded(String first, String second) {
        Collection a1 = new ArrayList();
        Collection a2 = new ArrayList();

        Collection temp1 = new ArrayList();
        Collection temp2 = new ArrayList();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        StringBuilder sbt1 = new StringBuilder();
        StringBuilder sbt2 = new StringBuilder();

        sb1.append(first); //adds string into SB
        sb2.append(second);

        sbt1.append(first);
        sbt2.append(second);

        //fills array a1 and a2 with ascii values of first string
        for(int i = 0; i < first.length(); i++ ){
            a1.add(sb1.charAt(i));
            temp1.add(sbt1.charAt(i));
        }
        for(int i = 0; i < second.length(); i++ ){
            a2.add(sb2.charAt(i));
            temp2.add(sbt2.charAt(i));
        }

        int total = sb1.length() + sb2.length();
        int newSize = 0;

        int prevSize1 = 0, prevSize2 = 0;

        System.out.println("\n A1: " + a1);
        System.out.println("\n A2: " + a2);


           //See how many have to be removed from A1
            prevSize1 = a1.size();
            prevSize2 = a2.size();
            //temp1 = a1;
            //temp2 = a2;
            //temp1.removeAll(temp2);
            //a2.removeAll(a1);

            System.out.println("New T1 - Prev Size :" + prevSize1 + " Contents:"  + temp1);
            System.out.println("New T2 - Prev Size :" + prevSize1 + " Contents:"  + temp2);
            System.out.println("New A1 - Prev Size :" + prevSize2 + " Contents:"  + a1);
            System.out.println("New A2 - Prev Size :" + prevSize2 + " Contents:"  + a2);

            //New
            temp1.removeAll(temp2);
            a2.removeAll(a1);
            System.out.println("\nNew T1 - Prev Size :" + prevSize1 + " Contents:"  + temp1);
            System.out.println("New A2 - Prev Size :" + prevSize2 + " Contents:"  + a2);
            //newSize = prevSize1 + prevSize2 - (temp1.size() + temp2.size());
            newSize = temp1.size() + a2.size();


        return newSize;
    }
 */
