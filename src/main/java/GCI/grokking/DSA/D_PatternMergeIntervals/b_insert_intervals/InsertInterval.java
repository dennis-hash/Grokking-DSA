package GCI.grokking.DSA.D_PatternMergeIntervals.b_insert_intervals;


//Problem Statement #
//
//Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge
//all necessary intervals to produce a list that has only mutually exclusive intervals.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Example 1:
//
//Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
//Output: [[1,3], [4,7], [8,12]]
//Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
//
//Example 2:
//
//Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
//Output: [[1,3], [4,12]]
//Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
//
//Example 3:
//
//Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
//Output: [[1,4], [5,7]]
//Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
class Interval{
    int start;
    int end;
    public Interval (int start, int end){
        this.start = start;
        this.end =  end;
    }
}
class InsertInterval {

    public static List<Interval> insert(List<Interval> listOfIntervals, Interval newInterval){

     if(listOfIntervals == null || listOfIntervals.isEmpty()){
         return Collections.singletonList(newInterval);
     }

     List<Interval> mergedIntervals = new ArrayList<>();
     int i = 0;
     while(i < listOfIntervals.size() && listOfIntervals.get(i).end < newInterval.start){
         mergedIntervals.add(listOfIntervals.get(i));
         i++;
     }

     while(i < listOfIntervals.size() && listOfIntervals.get(i).start <= newInterval.end){
         newInterval.start = Math.min(listOfIntervals.get(i).start, newInterval.start);
         newInterval.end = Math.max(listOfIntervals.get(i).end, newInterval.end);
         i++;
     }

     mergedIntervals.add(newInterval);

     while(i<listOfIntervals.size()){
         mergedIntervals.add(listOfIntervals.get(i++));
     }



     return mergedIntervals;
    }
    public static void main (String [] args){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(3,4));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        for(Interval interval : InsertInterval.insert(input,new Interval(1,10))){
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

    }

}

