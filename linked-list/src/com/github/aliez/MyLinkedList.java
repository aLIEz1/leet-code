package com.github.aliez;

/**
 * 707
 *
 * @author lm
 * @date 2021/3/19 16:47
 */
public class MyLinkedList {

    static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
            this.next = null;
        }

        public LinkNode() {
        }
    }

    private LinkNode dummyHead;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.dummyHead = new LinkNode(0);
        this.size = 0;

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > (size - 1) || index < 0) {
            return -1;
        }
        LinkNode cur = dummyHead.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        LinkNode ln = new LinkNode();
        ln.val = val;
        ln.next = dummyHead.next;
        dummyHead.next = ln;
        size++;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        LinkNode ln = new LinkNode();
        ln.val = val;
        LinkNode cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = ln;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        LinkNode ln = new LinkNode(val);
        LinkNode cur = dummyHead;
        while (index-- > 0) {
            cur = cur.next;
        }
        ln.next = cur.next;
        cur.next = ln;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        LinkNode cur = dummyHead;
        while (index-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
