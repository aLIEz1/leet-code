package com.github.aliez;

import java.util.Stack;

/**
 * 151
 *
 * @author lm
 * @date 2021/3/30 17:26
 */
public class Solution151 {
    public String reverseWords(String s) {
        char[] oldCharArray = s.toCharArray();
        //去除前面的空格
        int slowIndex = 0, fastIndex = 0;
        while (oldCharArray.length > 0
                && fastIndex < oldCharArray.length
                && oldCharArray[fastIndex] == ' ') {
            fastIndex++;
        }
        //去掉中间多余的空格
        for (;fastIndex < oldCharArray.length;fastIndex++) {
            if (fastIndex - 1 > 0
                    && oldCharArray[fastIndex] == oldCharArray[fastIndex - 1]
                    && oldCharArray[fastIndex] == ' ') {
                continue;

            } else {
                oldCharArray[slowIndex++] = oldCharArray[fastIndex];
            }

        }
        //去掉末尾的空格
        char[] newCharArray;
        if (slowIndex - 1 > 0
                && oldCharArray[slowIndex - 1] == ' ') {
            newCharArray = new char[slowIndex - 1];
            System.arraycopy(oldCharArray, 0, newCharArray, 0, slowIndex - 1);
        } else {
            newCharArray = new char[slowIndex];
            System.arraycopy(oldCharArray, 0, newCharArray, 0, slowIndex);
        }

        String s1 = new String(newCharArray);
        Stack<String> stringStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s1.split(" ");
        for (String s2 : split) {
            stringStack.push(s2);
        }

        for (String s2 : split) {
            stringBuilder.append(stringStack.pop()).append(" ");
        }
        stringBuilder.deleteCharAt(newCharArray.length);
        return stringBuilder.toString();


    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords("  hello world!  "));
    }
}
