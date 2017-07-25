package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();

        input.add(new ArrayList<Integer>());
        input.add(new ArrayList<Integer>());
        input.add(new ArrayList<Integer>());

        input.get(0).add(1);
        input.get(0).add(0);
        input.get(0).add(1);

        input.get(1).add(1);
        input.get(1).add(1);
        input.get(1).add(1);

        input.get(2).add(1);
        input.get(2).add(1);
        input.get(2).add(1);

        System.out.println(input.toString() + '\n');
        output = setZeroes(input);
        System.out.println(output.toString() + '\n');
        // write your code here
    }

    public static ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> a) {

        ArrayList<Integer> blackList = new ArrayList<Integer>();
	    /*
	    Input:
	    [1  0   1]
	    [1  1   1]
	    [1  1   1]
	    Output:
	    [0  0   0]
	    [1  0   1]
	    [1  0   1]
	    */
	    int rowSize = a.get(0).size();
	    int colSize = a.size();
	    ArrayList<Integer> emptyRow = new ArrayList<>(Collections.nCopies(rowSize,0));
        ArrayList<Integer> emptyCol = new ArrayList<>(Collections.nCopies(rowSize,0));
        //Case 1
        ArrayList<Integer> deadIndex = new ArrayList<Integer>();
        for(int i = 0; i < rowSize; i++){
            boolean pruneRow = false;
            for(int j = 0 ; j < colSize; j++){
                if(a.get(i).get(j) == 0){
                    deadIndex.add(j);
                    if(!pruneRow){
                        pruneRow = true;
                    }
                }
            }
            if(pruneRow){
                a.set(i,emptyRow);
            }
        }
        while(!deadIndex.isEmpty()) {
            for (int i = 0; i < colSize; i++) {
                a.get(i).set(deadIndex.get(0), 0);
            }
            deadIndex.remove(0);
        }
        return a;
    }
    public static ArrayList<ArrayList<Integer>> setZeroesOLD(ArrayList<ArrayList<Integer>> a) {

        ArrayList<Integer> blackList = new ArrayList<Integer>();
	    /*
	    Input:
	    [1  0   1]
	    [1  1   1]
	    [1  1   1]
	    Output:
	    [0  0   0]
	    [1  0   1]
	    [1  0   1]
	    */
        //Case 1
        int zeroIndex = -1;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (!blackList.isEmpty()) {
                    //Check if on Zero Index (skip then)
                    if (blackList.contains(j)) {
                        j++; //skip index of row
                        continue;
                    }
                }
	             /*
        	    Input:
        	    [1  0   1]
        	    [1  1   1]
        	    [1  1   1]
        	    Output:
        	    [0  0   0]
        	    [1  0   1]
        	    [1  0   1]
        	    */
                zeroIndex = a.get(i).indexOf(0);
                if (blackList.contains(zeroIndex)) {
                    continue; //skip that shit
                }
                if (zeroIndex == -1) {
                    break; //no 0 in row
                } else {
                    blackList.add(zeroIndex);
                    //set row to 0
                    //ArrayList<Integer> pruned = new ArrayList<Integer>();
                    for (int k = 0; k < a.get(i).size(); k++) {

                        if (a.get(i).get(k) == 0) {
                            if (!blackList.contains(k)){
                                blackList.add(a.get(i).get(k));

                            }
                        }
                        //a.get(i).set(k,0); //set all row to 0 - do later
                        //if(k < a.size()){
                        //  a.get(k).set(zeroIndex,0);//cols to 0
                        //}
                    }//end-for
                    if(!blackList.isEmpty()) {
                        for (int w = 0; w < blackList.size(); w++) {
                            for (int k = 0; k < a.size(); k++) {
                                a.get(k).set(blackList.get(w), 0); //does the cols
                            }
                            for (int k = 0; k < a.get(i).size(); k++) {
                                a.get(i).set(k, 0);
                            }

                        }
                    }
                }
                break;
            }

        }
        return a;
    }


}