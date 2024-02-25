package data_structures.queue_and_stack;

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
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
