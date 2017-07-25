package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList a = new ArrayList<Integer>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);

        arrangeO_N(a);
        System.out.println("Before: \n" + a.toString());

        System.out.println("After: \b" + a.toString());
    }
    public static void arrangeO_one(ArrayList<Integer> a){
        int n = a.size();

    }

    public static void arrangeO_N(ArrayList<Integer> a) {
        Collections.sort(a);
        // 4 0 2 1 3
        //Expected: 3 4 2 0 1
        //Arr[i] becomes Arr[Arr[i]]

        //(ArrayList<Object>)myTempObject.clone();

        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0 ; i < a.size(); i++){
            int val = 0;
            val = a.get(0);
            ret.add(val);
        }

        for(int i = 0 ; i < a.size(); i++){
            int val = ret.get(i);
            int insert = ret.get(val);
            a.set(i, ret.get(ret.get(i)));
        }

    }
}
