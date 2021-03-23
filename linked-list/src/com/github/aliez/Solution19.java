package com.github.aliez;

/**
 * 19
 *
 * @author lm
 * @date 2021/3/22 15:51
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        return dummyHead.next;
    }
}
