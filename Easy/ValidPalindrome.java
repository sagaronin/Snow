public class ValidPalindrome {
    // Question
    /*
     * A phrase is a palindrome if, after converting all uppercase letters into
     * lowercase letters and removing all non-alphanumeric characters, it reads the
     * same forward and backward. Alphanumeric characters include letters and
     * numbers.
     * 
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     * 
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     */
    public static void main(String[] args) {
        System.out.println("is Palindrome? : " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("is Palindrome? : " + isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            char cHead = s.charAt(head);
            char cTail = s.charAt(tail);
            // escape if no letter or digit is present
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                // check if chars are not equal, if not return false directly
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                // if chars are same then increament head and tail
                head++;
                tail--;
            }
        }
        return true;
    }
}
