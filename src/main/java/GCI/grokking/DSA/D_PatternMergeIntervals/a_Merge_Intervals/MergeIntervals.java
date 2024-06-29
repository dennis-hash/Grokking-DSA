package GCI.grokking.DSA.D_PatternMergeIntervals.a_Merge_Intervals;

import java.util.*;

//Problem Statement #
//
//Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
//
//        Example 1:
//
//Intervals: [[1,4], [2,5], [7,9]]
//Output: [[1,5], [7,9]]
//Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
//one [1,5].
//Example 2:
//
//Intervals: [[6,7], [2,4], [5,9]]
//Output: [[2,4], [5,9]]
//Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
//
//
//Example 3:
//
//Intervals: [[1,4], [2,6], [3,5]]
//Output: [[1,6]]
//Explanation: Since all the given intervals overlap, we merged them into one.

class Interval{
    int start;
    int end;
    public Interval (int start, int end){
        this.start = start;
        this.end =  end;
    }
}
class MergeIntervals {
    public static List<Interval> merge (List<Interval> intervals){
        if(intervals.size() < 2){
            return intervals;
        }

        //sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));


        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalItr.hasNext()){
            interval = intervalItr.next();
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }else{
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }

        }

        //add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
    public static void main (String [] args){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(6,7));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        for(Interval interval : MergeIntervals.merge(input)){
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

    }

}

//Time complexity #
//
//The time complexity of the above algorithm is O(N∗logN)O(N∗logN), where ‘N’ is the total number of intervals. We are iterating the intervals only once which will take O(N)O(N), in the beginning though, since we need to sort the intervals, our algorithm will take O(N∗logN)O(N∗logN).
//Space complexity #
//
//The space complexity of the above algorithm will
// be O(N)O(N) as we need to return a list containing
// all the merged intervals. We will also need O(N)O(N) space for sorting. For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort, and both these algorithms need O(N)O(N) space. Overall, our algorithm has a space complexity of O(N)O(N).
