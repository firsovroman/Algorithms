package Search_Algorithms.binarySearch;

public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));

    }


    public static int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int g = guess(mid);

            if (g == 0) {
                return mid;
            } else if (g == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return n;
    }


    public static int guess(int num) {
        if (num == 6) {
            return 0;
        } else if (num > 6) {
            return -1;
        } else {
            return 1;
        }
    }
}
