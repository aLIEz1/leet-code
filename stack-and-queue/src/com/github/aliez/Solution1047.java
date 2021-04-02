package com.github.aliez;

import java.util.Stack;

/**
 * 1047删除字符串中的所有相邻重复项
 * abbaca ca
 *
 * @author lm
 * @date 2021/4/2 14:28
 */
public class Solution1047 {
    public String removeDuplicates(String S) {
        Stack<Character> characterStack1 = new Stack<>();
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!characterStack1.isEmpty()) {
                if (array[i] == characterStack1.peek()) {
                    characterStack1.pop();
                } else {
                    characterStack1.push(array[i]);
                }
            } else {
                characterStack1.push(array[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = characterStack1.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(characterStack1.pop());
        }
        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution1047().removeDuplicates("abbaca"));
    }
}
