package dynamic_programming;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 3, 2, 1}; // 8
        int[] arr2 = {2, 1, 1, 2};

        System.out.println(rob(arr1)); // 8
//        System.out.println(rob(arr2)); // 4
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int a = dp[i - 1];
            int b = dp[i - 2] + nums[i];

            dp[i] = Math.max(a, b);
        }

        return dp[nums.length - 1];
    }
}
