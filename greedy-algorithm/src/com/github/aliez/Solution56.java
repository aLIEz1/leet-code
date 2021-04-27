package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56 合并区间
 *
 * @author lm
 * @date 2021/4/26 11:48
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1)[1] >= intervals[i][0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {

        int[][] ints = new int[4][];
        ints[0] = new int[]{1, 3};
        ints[1] = new int[]{2, 6};
        ints[2] = new int[]{8, 10};
        ints[3] = new int[]{15, 18};
        System.out.println(Arrays.deepToString(new Solution56().merge(ints)));
    }
}
