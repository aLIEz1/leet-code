package com.github.aliez;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 56 合并区间
 *
 * @author lm
 * @date 2021/4/26 11:48
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.peekLast()[1] >= intervals[i][0]) {
                list.peekLast()[1] = Math.max(list.peekLast()[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][];
        ListIterator<int[]> it = list.listIterator();
        int i = 0;
        while (it.hasNext()) {
            ans[i] = it.next();
            i++;
        }
        return ans;

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
