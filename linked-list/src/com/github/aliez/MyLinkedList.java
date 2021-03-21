package com.github.aliez;

/**
 * 707
 *
 * @author lm
 * @date 2021/3/19 16:47
 */
public class MyLinkedList {
    private int val;
    private MyLinkedList next;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int count = 0;
        MyLinkedList cur = this;
        while (cur.next != null) {
            if (count==index) {
                return cur.val;
            } else {
                cur = cur.next;
                count++;
            }
        }
        return -1;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        myLinkedList.next= this;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        MyLinkedList cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = myLinkedList;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        MyLinkedList cur = this;
        int count = 0;
        if (index < 0) {
            addAtHead(val);
        }
        while (cur.next != null) {
            if (count == index) {
                myLinkedList.next=cur.next;
                cur.next=myLinkedList;
            }
            cur = cur.next;
            count++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        MyLinkedList cur =this;
        int count=0;
        while (cur.next!=null){
            if (count==index){
                cur.next=cur.next.next;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
//        System.out.println(linkedList.get(2));
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        System.out.println(linkedList.get(1));
    }
}
