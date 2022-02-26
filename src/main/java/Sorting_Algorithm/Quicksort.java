package Sorting_Algorithm;

import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {

        int [] array = new int [] {34, 42, 35, 64, 15, 23, 12, 23, 88, 76};

        quickSort(array, 0, array.length-1);

        System.out.println("After sorting: " + arrayToString(array));
    }

    public static void quickSort(int [] arr, int from, int to) {

        if(from < to) {

            int divideIndex = partition(arr, from, to);
            printSortStep(arr, from,to,divideIndex);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }
    }


    public static int partition(int [] arr, int from, int to) {

        int rightIndex = to;
        int leftIndex = from;

        int referenceElement = arr[from + (to - from)/2];


        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < referenceElement) {
                leftIndex++;
            }

            while (arr[rightIndex] > referenceElement) {
                rightIndex--;
            }

            if(leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }

}
