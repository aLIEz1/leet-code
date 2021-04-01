# Leetcode刷题记录

## KMP算法：求next数组问题

注意要将next数组求得的值减一，防止next数组对应的数字与下标相同导致的回溯时造成死循环。如下图

![](https://github.com/aLIEz1/leet-code/blob/master/static-file/s28-1.png?raw=true)

![](https://github.com/aLIEz1/leet-code/blob/master/static-file/s28-2.png?raw=true)



具体求next数组的代码如下

```java
private int[] getNext(String s) {
    char[] charArray = s.toCharArray();
    int[] next = new int[charArray.length];
    int j = -1;
    next[0] = j;
    for (int i = 1; i < charArray.length; i++) {
        //注意这里时与j+1位置上进行比较，且j>=0
        while (j >= 0 && charArray[i] != charArray[j+1]) {
            j = next[j];
        }
        if (charArray[i] == charArray[j+1]) {
            j++;
        }
        next[i] = j;
    }
    return next;
}
```

KMP不仅可以解决字符串匹配问题，还可以判断一个字符串是否由它的一个子串重复多次构成

具体思路是检查next数组最后一位是否为-1；若不为-1则说明该字符串有最长的相同前后缀，再进行如下判断



![](https://github.com/aLIEz1/leet-code/blob/master/static-file/s459-1.png?raw=true)



![](https://github.com/aLIEz1/leet-code/blob/master/static-file/s459-2.png?raw=true)



具体代码如下



```java
package com.github.aliez;

/**
 * 459
 *
 * @author lm
 * @date 2021/4/1 12:54
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length()==0){
            return false;
        }
        char[] array = s.toCharArray();
        int[] next = getNext(s);
        return next[next.length - 1] != -1 && array.length % (array.length - (next[next.length - 1] + 1)) == 0;

    }

    private int[] getNext(String s){
        char[] array = s.toCharArray();
        int[] next = new int[array.length];
        int j=-1;
        next[0]=j;
        for (int i=1;i<array.length;i++){
            while (j>=0&&array[i]!=array[j+1]){
                j=next[j];
            }
            if (array[i]==array[j+1]){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("ababab"));
        //true
    }
}

```

## 栈与队列

### 用栈实现队列

要注意，当输出栈有元素的时候，直接pop输出栈即可，没有元素时再将输入栈压入输出栈

具体代码如下

```java
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
        //此处一定要先判断一下是否为空
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

```

