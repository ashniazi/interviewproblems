package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
    }

    //  [1,3,5,6], 2 > 1
    public static int binarySearch(ArrayList<Integer> a, int b){
        int start = 0;
        int end = a.size()-1;
        boolean biggerTwice = false;

        if(b > a.get(end)){
            return end+1;
        }else if(b < a.get(start)){
            return 0;
        }

        while(!biggerTwice){
            int mid = start + (int)Math.floor((end-start)/2);
            //Case 1: Mid is equal to value
            if(a.get(mid) == b){
                return mid;
            }else if(b < a.get(mid)){
                if(start == end){
                    if(a.get(mid-1) < b){
                        biggerTwice = true;
                        return (mid+1);
                    }else{
                        biggerTwice = true;
                        return (mid-1);
                    }
                }
                end = mid -1;
            }else{
                if(start == end){
                    if(a.get(mid-1) <b){
                        biggerTwice = true;
                        return (mid+1);
                    }else{
                        biggerTwice = true;
                        return (mid-1);
                    }
                }
                start = mid + 1;
            }
        }//end while
        return -1;
    }//end static

}
