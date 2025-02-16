import java.util.Stack;

public class ValidParenthesis {
    // Question
    /*
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and
     * ']', determine if the input string is valid.
     * 
     * An input string is valid if:
     * 
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     * 
     * 
     * Example 1:
     * 
     * Input: s = "()"
     * 
     * Output: true
     */
    public static void main(String[] args) {
        System.out.println("is valid? (Optimal): "+isValid("()[]{}"));
    }
    public static boolean isValid(String parenthesis){
        if(parenthesis.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char character : parenthesis.toCharArray()) {
            if(character=='('){
                stack.push(')');
            }else if(character=='{'){
                stack.push('}');
            }else if(character=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop()!=character)
                return false;
        }
        return true;
        
    }
}
