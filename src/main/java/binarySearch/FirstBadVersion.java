package binarySearch;

public class FirstBadVersion {


    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isVer = isBadVersion(mid);

            if(isVer) {
                int dec = mid - 1;
                if(!isBadVersion(dec)) {
                    return mid;
                } else {
                    end = dec;
                }
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

}
