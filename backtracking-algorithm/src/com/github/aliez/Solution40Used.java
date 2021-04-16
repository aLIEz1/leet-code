package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90 组合总和 II
 *
 * @author lm
 * @date 2021/4/16 9:26
 */
public class Solution40Used {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;


    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtracking(candidates, target, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 2};
        System.out.println(new Solution40Used().combinationSum2(candidates, 3));
    }

}
