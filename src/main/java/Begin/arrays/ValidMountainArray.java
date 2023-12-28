package Begin.arrays;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

public class ValidMountainArray {

    public static void main(String[] args) {

        int[] arr = {1,3,2};
        System.out.println(validMountainArray(arr)); // true

        int[] arr2 = {3, 5, 5};
        System.out.println(validMountainArray(arr2)); // false

        int[] arr3 = {0, 3, 2, 1};
        System.out.println(validMountainArray(arr3)); // true

    }

    public static boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int n = arr.length;
        int i = 0;

        // Подъем
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Пик не может быть первым или последним элементом
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Спуск
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
