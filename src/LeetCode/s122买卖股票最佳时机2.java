package LeetCode;

public class s122买卖股票最佳时机2 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        int max;
        for (int i = 1; i < prices.length; i++) {
            max = prices[i];
            if (min <= max) {
                result += max - min;
            }
            min = max;
        }
        return result;
    }
    public int maxProfitByDP(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

}
