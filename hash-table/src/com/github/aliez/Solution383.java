package com.github.aliez;

/**
 * 383
 *
 * @author lm
 * @date 2021/3/26 15:24
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            array[ransomNote.charAt(i)-'a']--;
            if (array[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;

    }
}
