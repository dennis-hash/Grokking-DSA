package GCI.grokking.DSA.A_PatternSlidingWindow.f_No_repeat_substring;

//Given a string, find the length of the
// longest substring which has no repeating characters.

//Input: String="aabccbb"
//Output: 3
//Explanation: The longest substring without any repeating characters is "abc".

//Input: String="abbbb"
//Output: 2
//Explanation: The longest substring without any repeating characters is "ab".

//Input: String="abccde"
//Output: 3
//Explanation: Longest substrings without any repeating characters are "abc" & "cde".

import GCI.grokking.DSA.A_PatternSlidingWindow.c_smallest_SubarrayWithADivenSum.MinSizeSubArraySum;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int findLength(String str){
        Map<Character, Integer> countMap = new HashMap<>();
        int startWindow = 0, endWindow , maxLength = 0;
        char character;

        for (endWindow = 0; endWindow < str.length(); endWindow++){
            character = str.charAt(endWindow);

            if (countMap.containsKey(character)){
                startWindow = Math.max(startWindow, countMap.get(character) +1);
            }else{
                countMap.put(character, endWindow);
                maxLength = Math.max(maxLength, endWindow - startWindow + 1);
            }

        }

        return maxLength;
    }

    public static void main (String[] args){
        int result = NoRepeatSubstring.findLength("adcfga");
        System.out.println("length size" + result);

    }

}
