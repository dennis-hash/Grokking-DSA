package GCI.grokking.DSA.D_PatternMergeIntervals.c_interval_intersections;


import java.util.ArrayList;
import java.util.List;

class Interval{
    int start;
    int end;
    public Interval (int start, int end){
        this.start = start;
        this.end =  end;
    }
}
class IntervalsIntersections {
    public static Interval[] merge (Interval[] arr1, Interval[] arr2){
        List<Interval> result= new ArrayList<Interval>();

        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length){
            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)){
                result.add(new Interval(Math.max(arr1[i].start,arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }

            if(arr1[i].end < arr2[j].end){
                i++;
            }else{
                j++;
            }
        }

        return result.toArray(new Interval[0]);


    }

    public static void main (String[] args){
        Interval[] input1 = new Interval[] {new Interval(1,3), new Interval(5,6),new Interval(7,9)};
        Interval[] input2 = new Interval[] {new Interval(2,3), new Interval(5,7)};
        Interval[] result = IntervalsIntersections.merge(input1,input2);
        for(Interval interval : result){
            System.out.println("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();


    }
}
