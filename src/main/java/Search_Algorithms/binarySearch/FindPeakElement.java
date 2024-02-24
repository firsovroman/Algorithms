package Search_Algorithms.binarySearch;

public class FindPeakElement {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1}; // 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4}; // 5
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement(nums2));

    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

}
