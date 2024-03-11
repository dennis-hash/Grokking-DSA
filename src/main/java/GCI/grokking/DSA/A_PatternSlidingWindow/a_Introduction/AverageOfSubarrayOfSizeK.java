package GCI.grokking.DSA.A_PatternSlidingWindow.a_Introduction;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages (int k, int[] arr){
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        //int windowEnd = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd]; //adding the next element
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;

    }
    public static void main (String[] args){
        double[] results = AverageOfSubarrayOfSizeK.findAverages(5, new int[] {1,2,3,4,5,6,7,8});
        System.out.println("Avarages" + Arrays.toString(results));

    }


}

