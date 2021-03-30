package com.github.aliez;

/**
 * 剑指offer05
 *
 * @author lm
 * @date 2021/3/30 16:51
 */
public class Solution05 {
    public String replaceSpace(String s) {
        char[] oldCharArray = s.toCharArray();
        int count = 0;
        //统计空格个数
        for (char c : oldCharArray) {
            if (c == ' ') {
                count++;
            }
        }
        char[] newCharArray = new char[oldCharArray.length + (2 * count)];
        //数组拷贝操作！！！！
        System.arraycopy(oldCharArray, 0, newCharArray, 0, oldCharArray.length);
        for (int i = newCharArray.length - 1, j = oldCharArray.length - 1; j < i; i--, j--) {
            if (oldCharArray[j] != ' ') {
                newCharArray[i] = newCharArray[j];
            } else {
                newCharArray[i] = '0';
                newCharArray[i - 1] = '2';
                newCharArray[i - 2] = '%';
                i -= 2;
            }
        }
        return new String(newCharArray);

    }

    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        System.out.println(solution05.replaceSpace("we are happy"));

    }
}
