package com.github.aliez;

/**
 * 链表
 *
 * @author lm
 * @date 2021/3/19 16:23
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
