package com.company;

import java.util.List;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> newL = new ArrayList<Integer>();
        newL.add(5);
        newL.add(5);
        newL.add(7);
        newL.add(7);
        newL.add(8);
        newL.add(8);
        newL.add(10);
        System.out.println(findCount(newL, 8));

    }

    public static int findCount(final List<Integer> a, int b) {
        int count = 0;
        //System.out.println(hi);
        boolean flag = true;
        List<Integer> copyL = new ArrayList<Integer>(a);

        while(flag){
            int val = BinarySearch(copyL, b);
            if( val >= 0){
                count++;
                copyL.subList(0,2);
            }else if(val == -1){
                flag = false;
            }
        }
        //System.out.println(BinarySearch(a,b));

        return count;

    }
    public static int BinarySearch(List<Integer> as, int b){
        int hi = as.size()-1;
        int lo = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(as.get(mid) == b){
                return mid;
            }else if(b < as.get(mid)){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }


}

/* Correct
public int findCount(final List<Integer> A, int B) {
	    int lower, upper;
	    int len = A.size();

	    lower = lowerBound(A, 0, len - 1, B);
	    upper = upperBound(A, 0, len - 1, B);

	    if (lower == -1)
	        return 0;

	    return upper - lower + 1;

	}

	public int lowerBound(final List<Integer> A, int start, int end, int num) {

	    int steps = end - start + 1;
	    int mid;
	    int low = -1;
	    int val;

	    while (steps > 0) {

	        mid = (start + end) / 2;
	        val = A.get(mid);

	        if (num < val) {
	            end = mid - 1;
	        } else if (num > val) {
	            start = mid + 1;
	        } else {
	            low = mid;
	            end = mid - 1;
	        }

	        steps /= 2;
	    }

	    return low;

	}

	public int upperBound(final List<Integer> A, int start, int end, int num) {

	    int steps = end - start + 1;
	    int mid;
	    int up = end + 1;
	    int val;

	    while (steps > 0) {

	        mid = (start + end) / 2;
	        val = A.get(mid);

	        if (num < val) {
	            end = mid - 1;
	        } else if (num > val) {
	            start = mid + 1;
	        } else {
	            up = mid;
	            start = mid + 1;
	        }

	        steps /= 2;
	    }

	    return up;

	}


 */
