package data_structures.array_and_string;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));
        sb.reverse();

        int res;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        if(x < 0) {
            res = -res;
        }

        return res;
    }

}
