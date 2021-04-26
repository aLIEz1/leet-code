package com.github.aliez;

import java.util.ArrayList;
import java.util.List;

/**
 * 763 划分字母空间
 * 一个区间内尽可能少的包含的种类少->片段最多
 * 使用Set来去重，空间复杂对高，使用数组
 *
 * @author lm
 * @date 2021/4/26 10:25
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        char[] array = S.toCharArray();
        int[] alpha = new int[27];
        for (int i = 0; i < array.length; i++) {
            alpha[array[i] - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < array.length; i++) {
            right = Math.max(right, alpha[array[i] - 'a']);
            if (i == right) {
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution763().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
