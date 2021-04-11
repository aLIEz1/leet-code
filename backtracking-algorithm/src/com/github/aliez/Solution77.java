package com.github.aliez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77 组合
 *
 * @author lm
 * @date 2021/4/11 10:22
 */
public class Solution77 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            System.out.println("递归之前" + path);
            backtracking(n, k, i + 1);
            path.removeLast();
            System.out.println("递归之后" + path);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution77().combine(4, 2);
        System.out.println(combine);
    }
}
