package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 131 分割回文串
 *
 * @author lm
 * @date 2021/4/12 10:46
 */
public class Solution131 {

    boolean[][] dp;
    LinkedList<String> path = new LinkedList<>();
    List<List<String>> ans = new ArrayList<>();

    private boolean isPalindrome(char[] array, int left, int right) {
        while (right > left) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void backtracking(char[] array, int startIndex) {
        if (startIndex >= array.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (!dp[startIndex][i]) {
                continue;
            }
            String substring = new String(array, startIndex, i + 1 - startIndex);
            path.add(substring);
            backtracking(array, i + 1);
            path.removeLast();

        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (array[i] == array[j]) && dp[i + 1][j - 1];
            }
        }
        backtracking(array, 0);


        return ans;
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition("aab"));
//        System.out.println(solution131.isPalindrome(""));
    }
}
