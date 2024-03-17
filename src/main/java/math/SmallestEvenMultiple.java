package math;

public class SmallestEvenMultiple {


    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(5)); // 10
    }

    public static int smallestEvenMultiple(int n) {
        if (n <= 2) return 0;

        for (int i = n; i * i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0 && i % n == 0) {
                return i;
            }
        }
        return -1;
    }

}
