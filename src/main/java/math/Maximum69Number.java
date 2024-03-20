package math;

import java.util.Stack;

public class Maximum69Number {

    public static void main(String[] args) {

        System.out.println(maximum69Number(9669));

    }

    public static int maximum69Number(int num) {

        Stack<Integer> stack = new Stack<>();

        int temp = num;
        while (temp > 0) {
            int cif = temp % 10;
            stack.push(cif);
            temp = temp / 10;
        }

        boolean first = true;

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int cifra = stack.pop();
            if (cifra == 6 && first) {
                cifra = 9;
                first = false;
            }
            sb.append(cifra);
        }


        return Integer.valueOf(sb.toString());
    }
}
