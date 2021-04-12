package com.github.aliez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39 组合总和
 *
 * @author lm
 * @date 2021/4/12 9:18
 */
public class Solution39 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;

    private void backtracking(int[] candidates, int target, int startIndex) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i);
            sum -= candidates[i];
            path.removeLast();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return ans;
    }
}
