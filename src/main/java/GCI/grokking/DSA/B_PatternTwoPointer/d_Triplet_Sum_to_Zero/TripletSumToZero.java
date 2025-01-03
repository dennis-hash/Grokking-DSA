package GCI.grokking.DSA.B_PatternTwoPointer.d_Triplet_Sum_to_Zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Problem Statement #
//Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
//Example 1:
//Input: [-3, 0, 1, 2, -1, 1, -2]
//Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
//Explanation: There are four unique triplets whose sum is equal to zero.
//        Example 2:
//Input: [-5, 2, -1, -2, 3]
//Output: [[-5, 2, 3], [-2, -1, 3]]
//Explanation: There are two unique triplets whose sum is equal to zero.
public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }
    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }
    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}

//Sorting the array will take O(N ∗ logN ). The searchPair() function will take O(N ). As we are calling
//searchPair() for every number in the input array, this means that overall searchTriplets() will take
//O(N ∗ logN + N 2 ), which is asymptotically equivalent to O(N 2​ ).
//Space complexity #
//Ignoring the space required for the output array, the space complexity of the above algorithm will be
//O(N ) which is required for sorting.
