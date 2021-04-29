package com.github.aliez;

/**
 * 70 爬楼梯
 *
 * @author lm
 * @date 2021/4/29 11:08
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
