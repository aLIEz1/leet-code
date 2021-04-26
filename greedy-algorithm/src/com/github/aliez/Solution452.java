package com.github.aliez;

/**
 * 452 用最少的箭引爆气球
 *
 * @author lm
 * @date 2021/4/25 17:37
 */
public class Solution452 {
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
            if (nums[i][0] < nums[pivot][0]) {
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

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        quickSort(points, 0, points.length - 1);
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                ans++;
            } else {
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return ans;
    }

}
