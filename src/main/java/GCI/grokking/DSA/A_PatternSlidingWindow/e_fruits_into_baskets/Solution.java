package GCI.grokking.DSA.A_PatternSlidingWindow.e_fruits_into_baskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int fruitsIntoBaskets(char[] arr) {
        int windowStart = 0;
        int maxFruits = 0;
        Map<Character, Integer> mp= new HashMap<>();

        for( int windowEnd = 0; windowEnd < arr.length;windowEnd++ ){
           mp.put(arr[windowEnd], mp.getOrDefault(arr[windowEnd],0)+1);

           if(mp.size() > 2){
               mp.put(arr[windowStart], mp.get(arr[windowStart]) - 1);
           }
        }
        return maxFruits;

    }
    public static void main (String[] args){
      char[] trees = {'A','B','C'};
      int max = Solution.fruitsIntoBaskets(trees);
      System.out.println(max);
    }
}
