package com.github.aliez;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 454
 *
 * @author lm
 * @date 2021/3/26 14:50
 */
public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> countAB = new HashMap<>(2);

        for (int i : A) {
            for (int i1 : B) {
                countAB.put(i+i1,countAB.getOrDefault(i+i1,0)+1);
            }
        }
        int count=0;
        for (int i : C) {
            for (int i1 : D) {
                if (countAB.containsKey(-(i + i1))){
                    count+=countAB.get(-(i+i1));
                }
            }
        }
        return count;
    }
}
