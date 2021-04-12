package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40 组合总和II
 *
 * @author lm
 * @date 2021/4/12 9:45
 */
public class Solution40 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;
    int pre = 0;

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target; i++) {
            if (pre == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
            pre = candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        new Solution40().combinationSum2(candidates, 3);
    }
}
