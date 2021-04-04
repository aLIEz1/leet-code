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



### 力扣232 用栈实现队列

要注意，当输出栈有元素的时候，直接pop输出栈即可，没有元素时再将输入栈压入输出栈

具体代码如下

```java
public int pop() {
    //此处一定要先判断一下是否为空
    if (!stack2.isEmpty()){
        return stack2.pop();
    }
    pushToStack2();
    return stack2.pop();
}
//讲输入栈压入输出栈
private void pushToStack2() {
    while (!stack1.empty()) {
        stack2.push(stack1.pop());
    }
}
//当两个栈都没有元素的时候，队列空
public boolean empty() {
    return stack2.empty() && stack1.empty();

}

```



### 力扣225 用队列实现栈

可以考虑简单的方法，只使用一个队列，入队前先取出队列的大小n，然后入队，再把前n个元素先出队后入队，这样新加入的元素就在队首了，代码如下



```java
public void push(int x) {
    int n = queue.size();
    queue.offer(x);
    for (int i = 0; i < n; i++) {
        queue.offer(queue.poll());
    }

}
```



### 力扣 1047  删除字符串中的所有相邻重复项

思路是依次将字符串压入栈，当遍历到当前的元素时与栈顶元素比较，若相同则弹栈，否则进栈

具体代码如下

```java
public String removeDuplicates(String S) {
    Stack<Character> characterStack1 = new Stack<>();
    char[] array = S.toCharArray();
    for (int i = 0; i < array.length; i++) {
        if (!characterStack1.isEmpty()) {
            if (array[i] == characterStack1.peek()) {
                characterStack1.pop();
            } else {
                characterStack1.push(array[i]);
            }
        } else {
            characterStack1.push(array[i]);
        }
    }
    StringBuilder stringBuilder = new StringBuilder();
    int size = characterStack1.size();
    for (int i = 0; i < size; i++) {
        stringBuilder.append(characterStack1.pop());
    }
    return stringBuilder.reverse().toString();

}
```

需要注意的是遍历栈时千万不能把栈的大小当成for结束的条件，因为栈的大小是动态变化的。

错误示例如下

```java
for (int i = 0; i < characterStack1.size(); i++) {
    stringBuilder.append(characterStack1.pop());
}
```

正确的做法应该是将 characterStack1.size()在for循环外取出

如下

```java
int size = characterStack1.size();
for (int i = 0; i < size; i++) {
    stringBuilder.append(characterStack1.pop());
}
```

```java
	String str = "123";
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher((CharSequence) str);
		boolean result = matcher.matches();
		if (result) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
```



### 力扣239 hard 滑动窗口最大值 



此题重难点是实现一个单调队列，队列里只维护可能为最大值的元素

实现滑动窗口，精髓在于此单调队列的pop()函数,每次移动时比较出窗口的元素与当前队首元素，若相等则说明此时最大值滑出窗口，要将队列中的队首元素弹出，

代码如下



```java
public void pop(int value) {
    if (!deque.isEmpty() && value == deque.getFirst()) {
        deque.pollFirst();
    }
}
```

入队操作就是比较当前要入队的元素与队尾元素，当要入队的元素大于队尾元素时将队尾元素弹出，直到要入队的元素小于队尾元素或者队为空时将要入队的元素入队



```java
public void push(int value) {
    while (!deque.isEmpty() && value > deque.getLast()) {
        deque.pollLast();
    }
    deque.offerLast(value);
}
```



实际操作队列时，要先将前k个元素一次性入队也就是执行push(value)操作，入队完成后取队首元素加入ArryList中，之后的元素每次执行循环都要执行pop(value)操作，因为窗口是滑动的，每次需要判断出窗口的是否为队列中最大的元素，然后将第i个元素入队，最后将队首元素添加到ArryList中去。

```java
public int[] maxSlidingWindow(int[] nums, int k) {
    MyQueue myQueue = new MyQueue();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        myQueue.push(nums[i]);
    }
    list.add(myQueue.peek());
    for (int i=k;i<nums.length;i++){
        myQueue.pop(nums[i-k]);
        myQueue.push(nums[i]);
        list.add(myQueue.peek());
    }
    return list.stream().mapToInt(i->i).toArray();
}
```

注意List数组可以通过`list.stream().mapToInt(i->i).toArray();`转换成int[]数组





### 力扣347 前K个高频元素

此题应用优先级队列对数字出现的频率进行排序，优先级队列`PriorityQueue`数据结构为小顶堆，即最小的元素在队首，小顶堆是一个完全二叉树，其父节点不大于左右子节点的值

此题思路是利用`getOrDefault()`函数对数组数字出现的频率进行统计，key为数组中的数组，value为数组中该数字出现的频率，然后将map中的键值对入队，当队中元素大于K个是出队，由于总是出现频率最小的在队首，所以每次弹出的都是频率最小的元素，剩下的就是前K个高频元素



该题需要自定义Entry键值对，如下：



```java
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
```



具体代码逻辑如下：



```java
for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
for (Integer integer : map.keySet()) {
    queue.add(new Entry<>(integer, map.get(integer)));
    if (queue.size() > k) {
        queue.poll();
    }
}
```

 另外，可以使用`Map.Entry.comparingByValue();`以`Entry`的值进行排序生成一个比较器

```java
Comparator<Map.Entry<Integer, Integer>> byValue = Map.Entry.comparingByValue();
```

构造优先级队列时将这个`Comparator`传入即可

```java
PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(byValue);
```







## 二叉树



### 力扣144 二叉树的前序遍历

递归解法较简单如下：

```java
ArrayList<Integer> ans = new ArrayList<>();


private void preorder(TreeNode root) {
    if (root == null) {
        return;
    }
    ans.add(root.val);
    preorder(root.left);
    preorder(root.right);
}

public List<Integer> preorderTraversal(TreeNode root) {
    preorder(root);
    return ans;
}
```



重点实现迭代解法，迭代解法利用了栈先入后出的特点，将二叉树的右节点先入栈，再将二叉树的左节点入栈，这样弹栈的时候，就是正常的顺序了

```java
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            //注意此处顺序是反的，先入右边再入左边，弹栈时才会是先左后右
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return ans;
    }
```



### 力扣94 二叉树的中序遍历

中序遍历迭代的思路是将树的左节点依次入栈，当左节点为空时弹栈，并将出栈的元素右节点赋值给当前root节点，如果出栈节点没有右节点，则不会进入`while (root != null)`循环

代码如下：

```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();

    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        ans.add(root.val);
        root = root.right;
    }
    return ans;
}
```



### 力扣145 二叉树的后序遍历

迭代思路与单词的反转类似，`are you ok` ----> `ok you are` 可以先将每个单词逐个反转 `era uoy ko`，再整体反转 `ok you are` 此题类似

前序遍历的顺序是`中左右`  ---->`中右左`  ----> `左右中`

后序遍历的顺序是`左右中`

具体思路时先将树的左节点入栈，再将右节点入栈，使用`LinkedList`保存，每次遍历前将栈顶元素弹出，头插法插入`LinkedList`，先遍历左节点后遍历右节点相当于局部反转，头插法相当于全局反转

具体代码如下

```java
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ans = new LinkedList<>();

    if (root == null) {
        return ans;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();

    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        ans.addFirst(cur.val);
        if (cur.left != null) {
            stack.push(cur.left);
        }
        if (cur.right != null) {
            stack.push(cur.right);
        }
    }
    return ans;

}
```

