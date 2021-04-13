package com.github.aliez;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 复原IP地址
 *
 * @author lm
 * @date 2021/4/12 14:37
 */
public class Solution93 {

    private boolean isValidNum(String s, int start, int end) {
        char[] array = s.toCharArray();
        if (start > end) {
            return false;
        }
        if (array[start] == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i < end; i++) {
            if (array[i] > '9' || array[i] < '0') {
                return false;
            }
            num = num * 10 + (array[i] - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int pointNum = 0;

    private void backtracking(String s, int startIndex) {
        if (pointNum == 3) {
            if (isValidNum(s, startIndex, s.length() - 1)) {
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = startIndex; i < sb.length(); i++) {
            if (isValidNum(s, startIndex, i)) {
                sb.insert(i + 1, '.');
                pointNum++;
                backtracking(s, i + 2);
                sb.deleteCharAt(i + 1);
                pointNum--;
            } else {
                break;
            }
        }
    }


    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12) {
            return ans;
        }
        char[] array = s.toCharArray();
        backtracking(s, 0);
        return ans;
    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("25525511135"));
    }
}
