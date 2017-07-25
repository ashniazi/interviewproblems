package com.company;

import java.util.ArrayList;

public class Main {

    public static class Interval{
        int start;
        int end;
        //Constructor
        Interval(){
            start = 0;
            end = 0;
        }
        //Setter
        Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
	// write your code here
        ArrayList<Interval> input = new ArrayList<>();
        Interval int_1 = new Interval(1,3);
        Interval int_2 = new Interval(6,9);
        //Interval int_3 = new Interval(6,7);
        //Interval int_4 = new Interval(8,10);
        //Interval int_5 = new Interval(12,16);
        input.add(int_1);
        input.add(int_2);
        //input.add(int_3);
        //input.add(int_4);
        //input.add(int_5);
        //System.out.println(input.get(0).start);

        //Interval nInterval = new Interval(4,9); //one we want to merge
        Interval nInterval = new Interval(4,5);
        System.out.println("To Merge:[" + nInterval.start + "," + nInterval.end + "]");
        ArrayList<Interval> ret = new ArrayList<>();

        System.out.println("Original Interval:");
        for(int i = 0; i < input.size(); i++){
            if(i != input.size() -1) {
                System.out.print("[" + input.get(i).start + "," + input.get(i).end + "],");
            }else{
                System.out.print("[" + input.get(i).start + "," + input.get(i).end + "]");
            }
        }
        System.out.println();
        ret = insert(input, nInterval); //works

        //System.out.println(ret.get(0).start);
        System.out.println("\nNew Interval:");
        for(int i = 0; i < ret.size(); i++){
            if(i != ret.size() -1) {
                System.out.print("[" + ret.get(i).start + "," + ret.get(i).end + "],");
            }else{
                System.out.print("[" + ret.get(i).start + "," + ret.get(i).end + "]");
            }
        }

    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
                                             Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();
        for(int i = 0; i < intervals.size(); i++){
            //Get Interval at this index.
            Interval interval = intervals.get(i);
            /*
            interval | new Interval
            [-------]|
                     | [-------]
             */
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.start){

            /*
            New interval | Interval
            [-------]|
                     | [-------]
            */
                result.add(newInterval);
                result.addAll(intervals.subList(i, intervals.size()));
                return result;
            }else{
                //operlapping, enlarge new interval to merge overlapping
                //interval
                int start = Math.min(newInterval.start, interval.start);
                int end = Math.max(newInterval.end, interval.end);
                newInterval.start = start;
                newInterval.end = end;
            }
        }
        result.add(newInterval);
        return result;
    }
}

/*
//Completed : Case 1: Inside
//            Case 2: One Merge
//
//            package com.company;
//
//import java.util.ArrayList;
//
//public class Main {
//
//    public static class Interval{
//        int start;
//        int end;
//        //Constructor
//        Interval(){
//            start = 0;
//            end = 0;
//        }
//        //Setter
//        Interval(int s, int e){
//            start = s;
//            end = e;
//        }
//    }
//
//    public static void main(String[] args) {
//	// write your code here
//        ArrayList<Interval> input = new ArrayList<>();
//        Interval int_1 = new Interval(1,3);
//        Interval int_2 = new Interval(6,9);
//        //Interval int_3 = new Interval(6,7);
//        //Interval int_4 = new Interval(8,10);
//        //Interval int_5 = new Interval(12,16);
//        input.add(int_1);
//        input.add(int_2);
//        //input.add(int_3);
//        //input.add(int_4);
//        //input.add(int_5);
//        //System.out.println(input.get(0).start);
//
//        //Interval nInterval = new Interval(4,9); //one we want to merge
//        Interval nInterval = new Interval(4,5);
//        System.out.println("To Merge:[" + nInterval.start + "," + nInterval.end + "]");
//        ArrayList<Interval> ret = new ArrayList<>();
//
//        System.out.println("Original Interval:");
//        for(int i = 0; i < input.size(); i++){
//            if(i != input.size() -1) {
//                System.out.print("[" + input.get(i).start + "," + input.get(i).end + "],");
//            }else{
//                System.out.print("[" + input.get(i).start + "," + input.get(i).end + "]");
//            }
//        }
//        System.out.println();
//        ret = insert(input, nInterval); //works
//
//        //System.out.println(ret.get(0).start);
//        System.out.println("\nNew Interval:");
//        for(int i = 0; i < ret.size(); i++){
//            if(i != ret.size() -1) {
//                System.out.print("[" + ret.get(i).start + "," + ret.get(i).end + "],");
//            }else{
//                System.out.print("[" + ret.get(i).start + "," + ret.get(i).end + "]");
//            }
//        }
//
//    }
//
//    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
//                                             Interval newInterval) {
//
//        //Check if input interval is sorted. If not, switch.
//        if(newInterval.start > newInterval.end){
//            int temp = newInterval.start;
//            newInterval.start = newInterval.end;
//            newInterval.end = temp;
//        }
//        //Get Length
//        int originalStart = intervals.get(0).start;
//        int originalEnd = intervals.get(intervals.size()-1).end;
//        int originalMid = intervals.get(intervals.size()/2).end;
//        System.out.println(originalStart);
//        System.out.println(originalEnd);
//        System.out.println(originalMid);
//
//        //boolean isOverlap = false;
//        boolean isDone = false;
//        //Cases: inside, left outside, right outside, no overlap
//
//        //Check for inside
//        /*
//           New           c-------d
//           Original:   a-----------b
//         */
//
//    //Find First Merged Index
//    int storedIndexStart = 0;
//for(int i = 0; i < intervals.size(); i++){
//        if(intervals.get(i).start < newInterval.start
//        &&
//        intervals.get(i).end < newInterval.end){
//        storedIndexStart = i;
//        break;
//        }
//        }
//        //Find End of Merged Index
//        for(int i = storedIndexStart+1; i < intervals.size(); i++ ){
//        if(intervals.get(i).start > newInterval.end){
//        //Merge previous with new interval
//        intervals.set(storedIndexStart, new Interval(intervals.get(storedIndexStart).start,newInterval.end));
//        isDone = true;
//        break;
//        }
//        }
//
//        if(intervals.get(originalStart).start < newInterval.start &&
//        intervals.get(originalEnd).end > newInterval.end && !isDone){
//        //then on the inside
//        }
//        //Case: No overlap / Inside
//        if(!isDone) {
//        for (int i = 0; i < intervals.size(); i++) {
//        if (intervals.get(i).start > newInterval.start) {
//        intervals.add(i, new Interval(newInterval.start, newInterval.end));
//        break;
//        }
//        }
//        }
//
//
//        return intervals;
//        }
//
//
//        }


