package GCI.grokking.DSA.A_PatternSlidingWindow.g_Longest_Substring_with_Same_Letters_after_Replacement;

//Problem Statement
//Given a string with lowercase letters only, if you are allowed
//to replace no more than ‘k’ letters with any letter,
//find the length of the longest substring having the same letters after replacement.

//Example 1:
//
//Input: String="abccbb", k=2
//Output: 5
//Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
//
//Example 2:
//
//Input: String="abbcb", k=1
//Output: 4
//Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
//
//Example 3:
//Input: String="abccde", k=1
//Output: 3
//Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".


//Solution #
//
//This problem follows the Sliding Window pattern and we can use a similar dynamic sliding
//window strategy as discussed in No-repeat Substring. We can use a HashMap to count the
//frequency of each letter.
//
// We’ll iterate through the string to add one letter at a time in the window.
// We’ll also keep track of the count of the maximum repeating letter in any window
// (let’s call it maxRepeatLetterCount). So at any time, we know that we can have a window
// which has one letter repeating maxRepeatLetterCount times, this means we should try
// to replace the remaining letters. If we have more than ‘k’ remaining letters, we should
// shrink the window as we are not allowed to replace more than ‘k’ letters.

import java.util.*;

public class CharacterReplacement {
    public static int findLength(String str, int k){
        int windowStart = 0, maxLength = 0, maxRepeatCount = 0;

        //hash map to count the frequency of each letter
        Map<Character, Integer> letterFrequencyMap =  new HashMap<>();


        //try to extend the range of [window start and window end ]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);

            maxRepeatCount = Math.max(maxRepeatCount, letterFrequencyMap.get(rightChar));

            //current window size = window end - window start
            if (windowEnd - windowStart + 1 - maxRepeatCount > k){
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) -1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main (String[] args){
        int result = CharacterReplacement.findLength("abccde",1);
        System.out.println("length of longest substring" + result);
    }
}
