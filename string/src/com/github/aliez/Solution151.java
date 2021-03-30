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
        while (fastIndex < oldCharArray.length) {
            if (fastIndex - 1 > 0
                    && oldCharArray[fastIndex] == oldCharArray[fastIndex - 1]
                    && oldCharArray[fastIndex] == ' ') {
                continue;

            } else {
                oldCharArray[slowIndex++] = oldCharArray[fastIndex];
            }

            fastIndex++;
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

        for (int i=0,j=newCharArray.length-1;i<j;i++,j--){
            char temp =newCharArray[i];
            newCharArray[i]=newCharArray[j];
            newCharArray[j]=temp;
        }

        for (int i=0;i<newCharArray.length;i++){
            //TODO 逐个翻转单词
        }


    }
}
