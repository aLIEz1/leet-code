package com.github.aliez;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435 无重叠区间
 *
 * @author lm
 * @date 2021/4/25 17:53
 */
public class Solution435 {
    private void quickSort(int[][] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[][] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i][1] < nums[pivot][1]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, --index);
        return index;
    }

    private void swap(int[][] nums, int p1, int p2) {
        if (p1 == p2) {
            return;
        }
        int[] tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        quickSort(intervals, 0, intervals.length - 1);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //记录非交叉区间
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }

        }
        //返回区间总数减去非交叉区间就是要求的
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[4][];
        nums[0] = new int[]{1, 2};
        nums[1] = new int[]{2, 3};
        nums[2] = new int[]{3, 4};
        nums[3] = new int[]{1, 3};
        System.out.println(new Solution435().eraseOverlapIntervals(nums));
    }
}
