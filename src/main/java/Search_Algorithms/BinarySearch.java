package Search_Algorithms;

public class BinarySearch {

    private static int[] sortedArray;

    public static void main(String[] args) {

        sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 41, 42, 43, 44, 45};

        int first = 0; //первый элемент массива
        int last = sortedArray.length - 1; //последний элемент массива

        System.out.println(binarySearch(sortedArray, 42, first, last));
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
