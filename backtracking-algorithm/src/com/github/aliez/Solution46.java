package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 46 全排列
 *
 * @author lm
 * @date 2021/4/14 16:57
 */
public class Solution46 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return ans;
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = {1, 2, 3};
        System.out.println(solution46.permute(nums));
    }
}
