package com.github.aliez;

import java.util.*;

/**
 * 347前K个高频元素
 *
 * @author lm
 * @date 2021/4/4 10:55
 */
public class Solution347 {
    static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(16);
        Comparator<Map.Entry<Integer, Integer>> byValue = Map.Entry.comparingByValue();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(byValue);
        ArrayList<Integer> list = new ArrayList<>();
        //统计各个数字出现的个数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            queue.add(new Entry<>(integer, map.get(integer)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(Objects.requireNonNull(queue.poll()).getKey());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 1, 1, 2, 3, 2, 3, 3, 0, 0};
        System.out.println(Arrays.toString(new Solution347().topKFrequent(nums, 2)));
    }
}
