package com.github.aliez;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406 根据身高重建队列
 *
 * @author lm
 * @date 2021/4/24 11:57
 */
public class Solution406 {

    static class MyList<T> {
        static class LinkNode<T> {
            T val;
            LinkNode<T> next;

            public LinkNode(T val) {
                this.val = val;
                this.next = null;
            }

            public LinkNode() {
            }
        }

        private LinkNode<T> dummyHead;
        private int size;

        public MyList() {
            this.dummyHead = new LinkNode<T>();
            this.size = 0;

        }

        public T get(int index) {
            if (index > (size - 1) || index < 0) {
                return null;
            }
            LinkNode<T> cur = dummyHead.next;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur.val;

        }

        public void addAtTail(T val) {
            LinkNode<T> ln = new LinkNode<>();
            ln.val = val;
            LinkNode<T> cur = dummyHead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = ln;
            size++;
        }

        public void addAtIndex(int index, T val) {
            if (index > size) {
                return;
            }
            LinkNode<T> ln = new LinkNode<>(val);
            LinkNode<T> cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            ln.next = cur.next;
            cur.next = ln;
            size++;

        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            LinkNode<T> cur = dummyHead;
            while (index-- > 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }

    }

    public int[][] reconstructQueue(int[][] people) {
        quickSort(people, 0, people.length - 1);
        MyList<int[]> list = new MyList<>();
        for (int[] person : people) {
            list.addAtTail(person);
        }
        for (int i = 0; i < people.length; i++) {

        }
        int[][] newPeople = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            newPeople[i] = list.get(i);
        }
        return newPeople;
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
        int[][] people = new int[6][];
        people[0] = new int[]{7, 0};
        people[1] = new int[]{4, 4};
        people[2] = new int[]{7, 1};
        people[3] = new int[]{5, 0};
        people[4] = new int[]{6, 1};
        people[5] = new int[]{5, 2};
        System.out.println(Arrays.deepToString(new Solution406().reconstructQueue(people)));
    }
}
