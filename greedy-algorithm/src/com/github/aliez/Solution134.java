package com.github.aliez;

/**
 * 134 加油站
 *
 * @author lm
 * @date 2021/4/22 17:17
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int totalSum = 0;
        int curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
