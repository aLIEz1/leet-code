package com.github.aliez;

/**
 * 242
 *
 * @author lm
 * @date 2021/3/23 17:05
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i)-97]--;
        }

        for (int i : array) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram("rat","cat"));
    }
}
