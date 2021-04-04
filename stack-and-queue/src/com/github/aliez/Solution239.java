package com.github.aliez;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 239滑动窗口最大值
 *
 * @author lm
 * @date 2021/4/2 15:38
 */
public class Solution239 {
    static class MyQueue {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        public void push(int value) {
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public void pop(int value) {
            if (!deque.isEmpty() && value == deque.getFirst()) {
                deque.pollFirst();
            }
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        list.add(myQueue.peek());
        for (int i=k;i<nums.length;i++){
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            list.add(myQueue.peek());
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new Solution239().maxSlidingWindow(nums, 3)));
    }
}
