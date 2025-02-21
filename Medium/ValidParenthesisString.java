package Medium;

public class ValidParenthesisString {
    // Question
    /*
     * Given a string s containing only three types of characters: '(', ')' and '*',
     * return true if s is valid.
     * 
     * The following rules define a valid string:
     * 
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left
     * parenthesis '(' or an empty string "".
     * 
     * 
     * Example 1:
     * 
     * Input: s = "()"
     * Output: true
     */
    public static void main(String[] args) {
        System.out.println("Is parenthesis valid string?: "+isValid("(((*)*"));
    }
    public static boolean isValid(String s){
        int min=0,max=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='('){
                min++;
                max++;
            }else if(ch==')'){
                min--;
                max--;
            }else if(ch=='*'){
                max++;
                min--;
            }
            if(max<0) return false;
            min=Math.max(min, 0);
        }
        return min==0;
    }
}
