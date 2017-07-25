package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        System.out.println("Output: " + singleNumber(a));
    }

    public static int singleNumber(final List<Integer> a) {
        //Collections.sort(a);
        System.out.println("List: " + a.toString());

        int x = 0;
        for(int i = 0 ; i < a.size(); i++){
            int val = a.get(i);
            x = x^val;
        }
        return x;
    }
}
