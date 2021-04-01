package com.github.aliez;

/**
 * 459
 *
 * @author lm
 * @date 2021/4/1 12:54
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length()==0){
            return false;
        }
        char[] array = s.toCharArray();
        int[] next = getNext(s);
        return next[next.length - 1] != -1 && array.length % (array.length - (next[next.length - 1] + 1)) == 0;

    }

    private int[] getNext(String s){
        char[] array = s.toCharArray();
        int[] next = new int[array.length];
        int j=-1;
        next[0]=j;
        for (int i=1;i<array.length;i++){
            while (j>=0&&array[i]!=array[j+1]){
                j=next[j];
            }
            if (array[i]==array[j+1]){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("ababab"));
    }
}
