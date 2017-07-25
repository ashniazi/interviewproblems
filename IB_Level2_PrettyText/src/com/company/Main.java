package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int n = 6;
        System.out.println("Given INT: " + n);
        ArrayList<ArrayList> ret = transform(n);

        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.size(); j++) {
                System.out.print(ret.get(i).get(j) + " ");
                if(j == ret.size()-1){
                    System.out.println();
                }
            }
        }
    }
    public static ArrayList<ArrayList> transform(int n){

        ArrayList<ArrayList> y_cols = new ArrayList<>();
        int defaultVal = 0;
        if(n%2 == 0){
            defaultVal = n / 2;
        }else{
            defaultVal = (n / 2) + 1;
        }
        int currVal = defaultVal;
        int rev = defaultVal;
        defaultVal = 0;
        //ArrayList<Integer> x_cols = new ArrayList<Integer>(Collections.nCopies(n,9)); //number of columns
        for(int i = 0 ; i < n ; i++){
            y_cols.add(new ArrayList<Integer>(Collections.nCopies(n,rev)));
        }
        int rightOffset = y_cols.size();
        int leftOffset = 0;
        for(int i = 0 ; i < y_cols.size(); i++){
            for(int j = 0 ; j < y_cols.size(); j++){
                if(i == 0 || i == y_cols.size()-1){
                    break;
                }
                if(j > leftOffset && j < rightOffset) {
                    ArrayList<Integer> preValue = y_cols.get(i - 1);
                    y_cols.get(i).set(j, preValue.get(j-1));
                }else {
                    leftOffset++;
                    rightOffset--;
                }
            }
        }

//        for(int i = 1; i < y_cols.size(); i++){
//            for(int j = i; j < y_cols.size(); j++){
//
//                y_cols.get(i).set(j,(int) y_cols.get(i).get(i) - 1);
//            }
//        }
        return y_cols;

    }
}
