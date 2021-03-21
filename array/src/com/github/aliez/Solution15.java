package com.github.aliez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 *
 * @author lm
 * @date 2021/3/16 17:11
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int leftIndex = 1;
        int rightIndex = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            while (leftIndex < rightIndex) {
                if (nums[i] + nums[leftIndex] + nums[rightIndex] > 0) {
                    rightIndex--;
                } else if (nums[i] + nums[leftIndex] + nums[rightIndex] < 0) {
                    leftIndex++;
                } else {
                    while (rightIndex>leftIndex&&nums[rightIndex]==nums[rightIndex-1]){
                        rightIndex--;
                    }
                    while (rightIndex>leftIndex&&nums[leftIndex]==nums[leftIndex+1]){
                        leftIndex++;
                    }
                    rightIndex--;
                    leftIndex++;
                    List<Integer> integers = Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]);
                    result.add(integers);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists);
    }
}
