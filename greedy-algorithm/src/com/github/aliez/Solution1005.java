package com.github.aliez;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1005 K 次取反后最大化的数组和
 *
 * @author lm
 * @date 2021/4/22 16:12
 */
public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {

        int sum = 0;
        int[] absA = Arrays.stream(A).boxed().sorted(Comparator.comparingInt(Math::abs)).mapToInt(i -> i).toArray();
        for (int i = absA.length - 1; i >= 0; i--) {
            if (absA[i] < 0 && K > 0) {
                absA[i] *= -1;
                K--;
            }
            sum += absA[i];

        }
        if (K > 0 && K % 2 != 0) {
            return sum - 2 * absA[0];
        }
        return sum;
    }


    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, (left + right) >> 1);

        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (Math.abs(nums[i]) > Math.abs(nums[pivot])) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, --index);
        return index;
    }

    private void swap(int[] nums, int p1, int p2) {
        if (p1 == p2) {
            return;
        }
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 0, 2};
        System.out.println(new Solution1005().largestSumAfterKNegations(nums, 3));
    }
}
