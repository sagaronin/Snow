package Medium;

import java.util.Arrays;

public class ReverseWordsInString {
    // Question
    /*
     * Given a character array s, reverse the order of the words.
     * 
     * A word is defined as a sequence of non-space characters. The words in s will
     * be separated by a single space.
     * 
     * Your code must solve the problem in-place, i.e. without allocating extra
     * space.
     * 
     * Example 1:
     * 
     * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     */
    public static void main(String[] args) {
        char s[] = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        reverseWords(s);
        System.out.println("Reverse words in string is: " + Arrays.toString(s));
    }

    public static void reverseWords(char s[]) {
        // Idea here is to
        // 1.Reverse the whole original array
        // 2.Then reverse only the words using the space char

        // 1. Reverse whole array
        swap(s, 0, s.length-1);

        int r = 0;
        // 2.reverse only the words using the space char from original reversed array
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') 
                r++;
            //reverse words one by one
            swap(s, l, r-1);
            r++;
        }

    }

    public static void swap(char s[], int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
