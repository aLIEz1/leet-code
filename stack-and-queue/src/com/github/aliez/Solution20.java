package com.github.aliez;

import java.util.Stack;

/**
 * 20有效的括号
 *
 * @author lm
 * @date 2021/4/1 16:41
 */
public class Solution20 {
    public boolean isValid(String s) {
        //如果长度为奇数，肯定不是合法的，直接返回false
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] array = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        characterStack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!characterStack.isEmpty()) {
                if (array[i] - characterStack.peek() <= 2 && array[i] - characterStack.peek() > 0) {
                    characterStack.pop();
                } else {
                    characterStack.push(array[i]);
                }
            } else {
                characterStack.push(array[i]);
            }

        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("(]"));
    }
}
