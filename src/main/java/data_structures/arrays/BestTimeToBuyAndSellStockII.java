package data_structures.arrays;


public class BestTimeToBuyAndSellStockII {


    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1)); // 7
        System.out.println(maxProfit(prices2)); // 4
        System.out.println(maxProfit(prices3)); // 0

    }

    public static int maxProfit(int[] arr) {
        int i = 1;
        int j = 0;
        int sum = 0;

        while (i < arr.length) {
            if (arr[i] > arr[j]) {
                int diff = arr[i] - arr[j];
                sum += diff;
            }
            i++;
            j++;
        }

        return sum;
    }


}
