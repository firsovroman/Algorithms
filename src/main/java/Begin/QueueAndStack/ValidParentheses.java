package Begin.QueueAndStack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        String s = "()";
        System.out.println(isValid(s)); // true

        String s2 = "()[]{}";
        System.out.println(isValid(s2)); // true

        String s3 = "(]";
        System.out.println(isValid(s3)); // false

        String s4 = "((";
        System.out.println(isValid(s4)); // false

        String s5 = "([{}])";
        System.out.println(isValid(s5)); // true


    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (ch == ')' && pop != '(' || ch == ']' && pop != '[' || ch == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
