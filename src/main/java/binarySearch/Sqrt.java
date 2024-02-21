package binarySearch;

public class Sqrt {

    public static void main(String[] args) {


        System.out.println(mySqrt(8)); // 2

//        System.out.println(mySqrt(16)); // 4

    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1;
        long end = x;
        long sq = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                sq = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int) sq;
    }


}
