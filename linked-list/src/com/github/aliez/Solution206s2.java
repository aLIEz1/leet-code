package com.github.aliez;

/**
 * 206s2
 *
 * @author lm
 * @date 2021/4/1 14:24
 */
public class Solution206s2 {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp =cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
