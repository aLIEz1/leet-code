package com.github.aliez;

/**
 * 541
 *
 * @author lm
 * @date 2021/3/30 16:34
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += (2 * k)) {
            if (i + k <= s.length()) {
                for (int start = i, end = i + k - 1; start < end; start++, end--) {
                    char temp = charArray[start];
                    charArray[start] = charArray[end];
                    charArray[end] = temp;
                }
            } else {
                for (int start = i, end = s.length() - 1; start < end; start++, end--) {
                    char temp = charArray[start];
                    charArray[start] = charArray[end];
                    charArray[end] = temp;
                }
            }
        }
        return new String(charArray);
    }
}
