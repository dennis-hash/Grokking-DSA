package GCI.grokking.DSA.A_PatternSlidingWindow.d_Longest_Substring_with_K_Distinct_Characters;

import com.example.GrokkingCodingInterview.pattern_sliding_window.pattern_sliding_window.SmallestSubarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestSubstringWithKDistinctChars(String s, int k) {
        if(s == null || s.isEmpty() || k == 0) return 0;
        Map<Character, Integer> mp = new HashMap<>();
        int windowStart = 0;
        int maxLen = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            mp.put(right, mp.getOrDefault(right, 0) + 1);

            while(mp.size() > k) {
                System.out.println("map inside while loop" + mp);
                char left = s.charAt(windowStart);
                mp.put(left, mp.get(left) - 1);
                if(mp.get(left) == 0) {
                    mp.remove(left);
                }
                windowStart++;
            }
            System.out.println("windowend:" + windowEnd);
            System.out.println("windowStart:" + windowStart);
            System.out.println("maxlen before" + maxLen);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            System.out.println("maxlen after:" + maxLen);
            System.out.println("map" + mp);
        }
        return maxLen;



    }
    public static void main (String [] args){

        int maxLen = Solution.longestSubstringWithKDistinctChars("aaabcd", 2);
        System.out.println("longest substring:" + maxLen);
    }
}
