package com.github.aliez;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 349
 *
 * @author lm
 * @date 2021/3/23 17:21
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }
       return set2.stream().mapToInt(i->i).toArray();
    }
}
