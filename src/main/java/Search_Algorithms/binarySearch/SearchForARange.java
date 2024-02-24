package Search_Algorithms.binarySearch;

import java.util.Arrays;

public class SearchForARange {

    public static void main(String[] args) {

//        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = {2,2};

        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int leftIndex = findFirstPosition(nums, target);
        if (leftIndex == -1) {
            return result;
        }

        int rightIndex = findLastPosition(nums, target);

        result[0] = leftIndex;
        result[1] = rightIndex;

        return result;
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

}
