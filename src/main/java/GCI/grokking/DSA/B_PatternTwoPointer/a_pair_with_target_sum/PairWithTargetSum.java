package GCI.grokking.DSA.B_PatternTwoPointer.a_pair_with_target_sum;

import GCI.grokking.DSA.A_PatternSlidingWindow.a_Introduction.AverageOfSubarrayOfSizeK;

import java.util.Arrays;

//Problem Statement #
//Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the
//given target.
//Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given
//target.
//        Example 1:
//Input: [1, 2, 3, 4, 6], target=6
//Output: [1, 3]
//Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
//Time Complexity #
//The time complexity of the above algorithm will be O(N ), where ‘N’ is the total number of elements in
//the given array.
//Space Complexity #
//The algorithm runs in constant space O(1).
public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int endPointer = arr.length - 1;
        int startPointer = 0;
        int startValue, endValue;

        for(int i = 0; i < arr.length;i++ ){
            startValue = arr[startPointer];
            endValue = arr[endPointer];

            if(startValue + endValue == targetSum){
                return new int[] { startPointer, endPointer };
            } else if (startValue + endValue > targetSum) {
                endPointer--;
            }else {
                startPointer++;
            }
        }
        return new int[] { startPointer, endPointer};
    }
    public static void main (String[] args){
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

    }
}
