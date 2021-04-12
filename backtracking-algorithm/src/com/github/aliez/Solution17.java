package com.github.aliez;

import java.util.*;

/**
 * 17 电话号码的字母组合
 *
 * @author lm
 * @date 2021/4/11 17:26
 */
public class Solution17 {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Integer, String> map = new HashMap<>(16);


    private void backtracking(char[] array, int index) {
        if (index == array.length) {
            ans.add(String.valueOf(sb));
            return;
        }
        int digit = array[index] - '0';
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtracking(array, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        char[] array = digits.toCharArray();
        backtracking(array, 0);
        return ans;
    }

    public static void main(String[] args) {
        new Solution17().letterCombinations("23");
    }
}
