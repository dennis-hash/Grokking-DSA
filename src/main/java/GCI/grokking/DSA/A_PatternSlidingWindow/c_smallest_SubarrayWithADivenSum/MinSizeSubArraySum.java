package GCI.grokking.DSA.A_PatternSlidingWindow.c_smallest_SubarrayWithADivenSum;

//(EASY)
//Given an array of positive numbers and a positive number ‘S’,
// find the length of the smallest contiguous subarray whose
// sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

//example 1
//Input: [2, 1, 5, 2, 3, 2], S=7
//Output: 2
//Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

//Input: [2, 1, 5, 2, 8], S=7
//Output: 1
//Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

//Input: [3, 4, 1, 1, 6], S=8
//Output: 3
//Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].

import GCI.grokking.DSA.A_PatternSlidingWindow.a_Introduction.AverageOfSubarrayOfSizeK;

import java.util.Arrays;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr){

//        int maxSize = 0;
//        int arrSize = 0;
//        int minSize = 0;
//        int begin = 0, end = 0;
//
//        for (end = 0; end < arr.length; end ++  ){
//            maxSize = maxSize + arr[end];
//            System.out.println("loop " + maxSize);
//
//            if(maxSize >= S){
//
//                arrSize = (end + 1) - begin;
//                System.out.println("in if statement arraysize " + arrSize +" end " + end + "begin " + begin);
//
//                maxSize = maxSize - arr[begin];
//
//
//
//
//
//                begin++;
//            }
//
//        }
//
//        return  arrSize;

        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd ++){
            windowSum += arr[windowEnd];

            while (windowSum >= S){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                System.out.println("windowEnd " + windowEnd);
                System.out.println("windowStart " + windowStart);
                System.out.println("minLength " + minLength);

                windowSum -= arr[windowStart];
                windowStart ++;
            }

        }

        return minLength == Integer.MAX_VALUE ? 0 :minLength;
    }

    public static void main (String[] args){
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] {7, 2, 1, 5, 2, 8});
        System.out.println("MinSubArray size" + result);

    }

    public static class MinValueExample {

        public static void main(String[] args) {
            int[] numbers = {5, 2, 9, 1, 7};
            int minLength = Integer.MAX_VALUE;

            for (int number : numbers) {
                if (number < minLength) {
                    minLength = number;
                }
            }

            System.out.println("The minimum value in the array is: " + minLength);
        }
    }

}
