package com.github.aliez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216 组合总和III
 *
 * @author lm
 * @date 2021/4/11 13:16
 */
public class Solution216 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    int sum = 0;

    private void backtracking(int k, int n, int startIndex) {
        if (sum>n){
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, i + 1);
            sum -= i;
            path.pollLast();
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return ans;

    }

    public static void main(String[] args) {
        new Solution216().combinationSum3(3, 7);
    }
}
