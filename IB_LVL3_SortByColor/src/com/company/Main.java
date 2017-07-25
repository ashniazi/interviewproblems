package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList input = new ArrayList<Integer>();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(0);
        input.add(1);
        input.add(2);

        System.out.println("Input:  ");
        System.out.println(input.toString());
        //sortColors_Radix_Sort(input);
        sortColors(input);
        System.out.println("Output:  ");
        System.out.println(input.toString());
	// write your code here
    }

    //More efficient, just works with zeros and 2, the 1s will be sorted on its own.
    public static void sortColors(ArrayList<Integer> a){
        int zero = 0;
        int two = a.size() -1;
        for(int i = 0 ; i <= two;){
            if(a.get(i) == 0){
                int temp = a.get(zero);
                a.set(zero,0);
                a.set(i, temp);
                zero++;
                i++;
            } else if(a.get(i) == 2){
                int temp = a.get(two);
                a.set(two, 2);
                a.set(i, temp);
                two--;
            }else{
                i++;
            }
        }

    }

    public static void sortColors_Radix_Sort(ArrayList<Integer> a){
            if(a == null || a.size() < 2){
                return;
            }
            ArrayList<Integer> count = new ArrayList<Integer>(Collections.nCopies(3,0));
            int r=0, w=0, b = 0;
            for(int i = 0 ; i < a.size(); i++){
                int value = a.get(i);
                if(value == 0){
                    r++;
                    count.set(0, r);
                }else if(value == 1){
                    w++;
                    count.set(1, w);
                }else{
                    b++;
                    count.set(2, b);
                }
            }//end for
            int sum = r + w + b;
            int val = 0;
            while(r > 0){
                a.set(val, 0);
                count.set(0,r--);
                val++;
            }
            while(w> 0){
                a.set(val, 1);
                count.set(1,w--);
                val++;
            }
            while(b > 0){
                a.set(val, 2);
                count.set(2,b--);
                val++;
            }
        }

    public static void sortColorss(ArrayList<Integer> a) {

        int i;
        //int j = a.size()-1;
        for(i = 0; i < a.size(); i++){
            for(int j = a.size()-1 ; j >= i; j--){
                if(i!=j && a.get(i) - a.get(j) == 0){
                    //SWAP
                    int temp = a.get(i+1);
                    a.set(i+1, a.get(j));
                    a.set(j, temp);
                }//end if
            }
        }
    }
}
