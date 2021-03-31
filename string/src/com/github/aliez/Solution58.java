package com.github.aliez;

/**
 * 剑指offer58
 *
 * @author lm
 * @date 2021/3/31 13:59
 */
public class Solution58 {
    public String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();
        charArray = reverse(0, n, charArray);
        charArray = reverse(n, charArray.length, charArray);
        charArray = reverse(0, charArray.length, charArray);

        return new String(charArray);
    }

    private char[] reverse(int begin, int end, char[] chars) {
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(new Solution58().reverseLeftWords("abcdefg", 2));
    }
}
