package com.github.aliez;

/**
 * 28 KMP算法
 *
 * @author lm
 * @date 2021/3/31 21:22
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        int[] next = getNext(needle);

        int j = -1;
        for (int i = 0; i < haystackCharArray.length; i++) {
            while (j >= 0 && haystackCharArray[i] != needleCharArray[j+1]) {
                j = next[j];
            }
            if (haystackCharArray[i] == needleCharArray[j+1]) {
                j++;
            }
            if (j == (needleCharArray.length - 1)) {
                return (i - needleCharArray.length + 1);
            }
        }
        return -1;
    }

    private int[] getNext(String s) {
        char[] charArray = s.toCharArray();
        int[] next = new int[charArray.length];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < charArray.length; i++) {
            while (j >= 0 && charArray[i] != charArray[j+1]) {
                j = next[j];
            }
            if (charArray[i] == charArray[j+1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("a", "a"));
    }
}
