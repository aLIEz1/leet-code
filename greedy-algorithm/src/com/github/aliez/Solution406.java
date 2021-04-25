package com.github.aliez;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 406 根据身高重建队列
 *
 * @author lm
 * @date 2021/4/24 11:57
 */
public class Solution406 {


    public int[][] reconstructQueue(int[][] people) {
        quickSort(people, 0, people.length - 1);
        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            list.add(people[i]);
        }

        for (int i = 0; i < people.length; i++) {
            int position = people[i][1];
            ListIterator<int[]> listIterator = list.listIterator(position);
            listIterator.add(people[i]);
        }
        int[][] ans = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

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
            if (nums[i][0] > nums[pivot][0]) {
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

    public static void main(String[] args) {
        int[][] people = new int[10][];
        people[0] = new int[]{9, 0};
        people[1] = new int[]{7, 0};
        people[2] = new int[]{1, 9};
        people[3] = new int[]{3, 0};
        people[4] = new int[]{2, 7};
        people[5] = new int[]{5, 3};
        people[6] = new int[]{6, 0};
        people[7] = new int[]{3, 4};
        people[8] = new int[]{6, 2};
        people[9] = new int[]{5, 2};
        System.out.println(Arrays.deepToString(new Solution406().reconstructQueue(people)));
    }
}
