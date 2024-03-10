package dynamic_programming;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices)); // 5
        System.out.println(maxProfit(prices2)); // 0
    }

    public static int maxProfit(int[] prices) {
        int diffMax = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > min) {
                diffMax = Math.max(diffMax, prices[i] - min);
            }
        }
        return diffMax;
    }
}
