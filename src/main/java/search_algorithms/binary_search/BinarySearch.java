package search_algorithms.binary_search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(search(nums, target)); // 4
    }

    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        return binarySearch(nums, target, low, high);
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }

        return index;
    }
}
