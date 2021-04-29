package com.github.aliez;

/**
 * 714 买卖股票的最佳时机含手续费
 *
 * @author lm
 * @date 2021/4/27 16:17
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        int sell = 0;
        int buy = -prices[0];
        for (int price : prices) {
            sell = Math.max(sell, buy + price - fee);
            buy = Math.max(buy, sell - price);
        }
        return sell;
    }
}
