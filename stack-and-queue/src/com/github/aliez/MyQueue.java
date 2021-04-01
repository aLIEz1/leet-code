package com.github.aliez;

import java.util.Stack;

/**
 * 232用栈实现队列
 *
 * @author lm
 * @date 2021/4/1 14:36
 */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        pushToStack2();
        return stack2.pop();
    }

    private void pushToStack2() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty()){
            return stack2.peek();
        }
        pushToStack2();
        return stack2.peek();

    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.empty() && stack1.empty();

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
