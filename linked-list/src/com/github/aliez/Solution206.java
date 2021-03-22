package com.github.aliez;

/**
 * 206
 *
 * @author lm
 * @date 2021/3/22 15:25
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre =null;
        while (cur!=null){
            ListNode temp =cur.next;
            cur.next=pre;
            pre=cur;
            cur =temp;
        }
        return pre;

    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur =head;
        ListNode pre=null;

        return reverse(cur,pre);

    }
    public ListNode reverse(ListNode cur,ListNode pre){
        if (cur==null){
            return pre;
        }
        ListNode temp=cur.next;
        cur.next=pre;
        pre=cur;
        cur=temp;
      return   reverse(cur,pre);
    }
}
