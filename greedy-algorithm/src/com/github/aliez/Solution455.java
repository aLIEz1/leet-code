package com.github.aliez;

import java.util.Arrays;

/**
 * 455 分发饼干
 *
 * @author lm
 * @date 2021/4/17 11:50
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int index = s.length - 1;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                index--;
                count++;
            }
        }
        return count;
    }
}
