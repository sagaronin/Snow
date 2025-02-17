package Medium;

public class LongestPalindromicSubstring {
    // Question
    /*
     * Given a string s, return the longest
     * palindromic
     * 
     * substring
     * in s.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     *
     */
    public static void main(String[] args) {
        //Best trick to solve this question is consider for solving odd and even length srings
        // e.g. racecar & aabbaa
        System.out.println("Longest Palindromic substring is: " + longestpalindromicSubstring("racecar"));
    }

    public static String longestpalindromicSubstring(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // this is for the case when string is of odd length
            // e.g. racecar
            int len1 = expandFromMiddle(s, i, i);
            //// this is for the case when string is of even length
            // e.g. aabbaa
            int len2 = expandFromMiddle(s, i, i + 1);

            int len = Math.max(len1, len2);
            // based on max length of new palindromic string get the start and end of that
            // string
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        // Since end is not inclusive add 1 to end
        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null | left > right)
            return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
