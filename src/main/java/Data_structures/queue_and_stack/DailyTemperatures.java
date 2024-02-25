package Data_structures.queue_and_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *  Задача на монотонно убывающий стек
 *
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temp = new int[]{73, 74, 75, 71, 69, 72, 76, 73}; // [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

    public static int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}
