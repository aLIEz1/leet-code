package com.github.aliez;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 135分发糖果
 *
 * @author lm
 * @date 2021/4/23 14:57
 */
public class Solution135 {
    public int candy(int[] ratings) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        stack.push(ratings[0]);
        int flag = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > stack.peek()) {
                nums[i] = nums[i - 1] + 1;
            } else if (ratings[i] == stack.peek()) {
                flag = i;
                nums[i] = 1;
            } else {
                if (nums[i - 1] == 1) {
                    nums[i] = 1;
                    for (int i1 = i - 1; i1 >= flag; i1--) {
                        nums[i1] += 1;
                    }
                } else {
                    nums[i] = 1;
                }
            }
            stack.push(ratings[i]);
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        int sum = 0;
        int i = 0;
        int j = 1;
        while (j < ratings.length) {
            if (ratings[j] > ratings[i]) {
                candy[j] = candy[i] + 1;
            }
            i++;
            j++;
        }
        int k = ratings.length - 1;
        int m = ratings.length - 2;
        while (m >= 0) {
            if (ratings[m] > ratings[k] && candy[m] <= candy[k]) {
                candy[m] = candy[k] + 1;
            }
            m--;
            k--;
        }
        for (int i1 : candy) {
            sum += i1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candy = {1, 2, 87, 87, 87, 2, 1};
        System.out.println(new Solution135().candy(candy));
    }
}
