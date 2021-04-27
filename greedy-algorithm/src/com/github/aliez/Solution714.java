package com.github.aliez;

/**
 * 714 买卖股票的最佳时机含手续费
 *
 * @author lm
 * @date 2021/4/27 16:17
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            //此时亏本，保持原有状态即可
            if (price <= minPrice + fee) {
                continue;
            }
            //此时有利可图
            if (price > minPrice + fee) {
                //卖出
                ans += price - minPrice - fee;

                //TODO 使用动态规划解题，这一步不太懂
                minPrice = price - fee;
            }
        }
        return ans;
    }
}
