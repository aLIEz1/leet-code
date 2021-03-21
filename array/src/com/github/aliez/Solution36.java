package com.github.aliez;

/**
 * 解决方案
 *
 * @author lm
 * @date 2021/3/15 15:00
 */
public class Solution36 {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int middle=(start+end)/2;
            if (nums[middle]>target){
                end=middle-1;
            }else if (nums[middle]<target){
                start=middle+1;
            }else {
                return middle;
            }
        }
        return end+1;
    }
}
