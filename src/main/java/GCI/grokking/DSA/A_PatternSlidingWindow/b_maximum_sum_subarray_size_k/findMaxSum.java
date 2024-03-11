package GCI.grokking.DSA.A_PatternSlidingWindow.b_maximum_sum_subarray_size_k;

public class findMaxSum {
    public static int findMax(int k, int[] arr){
        int windowStart = 0;
        int maxSum = 0, windowSum = 0;
        int  windowEnd;

        for (windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];

            if (windowEnd >= k-1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }
    public static void main (String[] args){
        int max = findMaxSum.findMax(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println("max sum:" + max);
    }
}
