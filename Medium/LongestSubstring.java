package Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    // Questions
    /*
     * Given a string s, find the length of the longest
     * substring
     * without duplicate characters.
     *
     * Example 1:
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * 
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     */
    public static void main(String[] args) {
        System.out.println("Length of longest substring: "+longestSubstring("abcbcbbcdba"));
    }
    public static int longestSubstring(String s){
        int max=0;
        Set<Character> set = new HashSet<>();
        int right=0,left=0;
        while(right<s.length()){
            // if you try to add a duplicate element to a HashSet, 
            //the duplicate will simply be ignored, and the HashSet will remain unchanged.
            boolean isAdded =set.add(s.charAt(right));
            if(isAdded){//if added is set
                max = Math.max(max, right-left+1);
                right++;
            }else{// if not added in set
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

}
