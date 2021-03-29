package com.github.aliez;

/**
 * 344
 *
 * @author lm
 * @date 2021/3/26 18:04
 */
public class Solution344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
