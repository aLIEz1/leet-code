# Leet-code刷题记录

### leet-code五步刷题法

1. 第一遍，看题目，想解法，如果十几分钟想不出解法，看题解，看别人的解法，最好能默写出来
2. 第二遍，自己尝试写出
3. 第三遍，隔几天后再次写一次，体会+自己的优化
4. 第四遍，一周过去后，再来一遍
5. 第五遍，复习

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



### 力扣102 二叉树的层序遍历



解题思路:维护一个队列，取队列的长度进行出队操作，每次出队后将当前节点的左节点入队，右节点入队，将本次出队的元素加入到List集合中，再将本次循环得到的List数组加入的ans里

例如:

```
	 1

​ 2		 3

4	5	6	7
```

第一次入队1，队列大小为1，弹出`1`后队列加入`2 3` 第二次遍历队列大小为2 弹出`2 3 `入队 `4 5 6 7` 以此类推

具体代码如下：

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            assert cur != null;
            list.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        ans.add(list);
    }
    return ans;
}
```



### 力扣 226 翻转二叉树



此题思路是利用前序遍历的次序翻转当前节点左右节点的引用

利用迭代法写出二叉树前序遍历

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
    }
    return root;
}
```

此题可以用递归法解，如下

```java
public TreeNode invertTreePre(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTreePre(root.left);
    invertTreePre(root.right);
    return root;
}
```



注意，用递归法写的时候，中序遍历如果不注意会将一个子树翻转两次

代码如下



```java
    /**
     * 此解法为错误示范，中序遍历中间交换后右子树变成了左子树，这样做会将左子树翻转两次
     * 正确解法应该是将invertTree(root.right); 改成 invertTree(root.left)
     * @param root
     * @return
     */
    public TreeNode invertTreeIn(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeIn(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeIn(root.right);
        return root;
    }
```

### 力扣 101 对称二叉树

分几种情况

1. 左右都为空，对称
2. 左空右不空，不对称
3. 左不空右空，不对称
4. 左右都不为空，但是值不相等，不对称
5. 左右都不为空吗，值也相等，对称

出现第5种情况后，可以递归比较两边外侧的节点，递归比较两边内测的节点

如果外侧节点和内侧节点都相同，则返回true

具体代码如下：

```java
private boolean isSam(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
        return true;
    } else if (left != null && right == null) {
        return false;
    } else if (left == null && right != null) {
        return false;
    } else if (left.val != right.val) {
        return false;
    }
    boolean out = isSam(left.left, right.right);
    boolean inner = isSam(left.right, right.left);
    return out && inner;
}
```



迭代写法类似

注意`Queue` 的子类都不能实现插入`null` `LinkedList`可以插入`null`

代码如下：

```java
public boolean isSymmetric2(TreeNode root) {
    if (root == null) {
        return true;
    }
    //LinkedList 允许push(null)
    //Queue不允许添加null
    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(root.right);
    stack.push(root.left);
    while (!stack.isEmpty()) {
        TreeNode left = stack.pop();
        TreeNode right = stack.pop();
        if (left == null && right == null) {
            continue;
        }
        if ((left == null || right == null || (left.val != right.val))) {
            return false;
        }
        stack.push(left.left);
        stack.push(right.right);
        stack.push(left.right);
        stack.push(right.left);

    }
    return true;
}
```



### 力扣104 二叉树的最大深度

此题可以用层序遍历的方法求出最大深度，代码如下



```java
public int maxDepth2(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> queue =new LinkedList<>();
    queue.offer(root);
    int count=0;
    while (!queue.isEmpty()){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur.left!=null){
                queue.offer(cur.left);
            }
            if (cur.right!=null){
                queue.offer(cur.right);
            }

        }
        count++;
    }
    return count;
}
```



### 力扣111 二叉树的最小深度

注意：此题指的最小深度时指从根节点到最近叶子节点的最短路径上的节点数量。

![](https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg)



此时树的最小深度为2



解此题可用递归法解，

要注意两点，

- 当左子树为空，右子树不为空的时候，最小深度为右子树最小深度+1
- 当左子树不为空，右子树为空的时候，最小深度为左子树最小深度+1

代码如下：

相当于后序遍历 左右中

**只有当左右孩子都为空的时候，才说明遍历的最低点了。如果其中一个孩子为空则不是最低点**

```java
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int leftDepth = minDepth(root.left);//左
    int rightDepth = minDepth(root.right);//右
    //中
    if (root.left == null && root.right != null) {
        return 1 + rightDepth;
    }
    if (root.left != null && root.right == null) {
        return 1 + leftDepth;
    }
    return 1 + Math.min(leftDepth, rightDepth);
}
```



迭代法写法要注意：当首次遍历到一个节点的左右子树均为空，则此时遍历的高度为二叉树的最小高度，此时应该退出循环，返回树的最小高度，利用了层序遍历的特点。

代码如下



```java
public int minDepth2(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        depth++;
        int flag = 0;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            assert cur != null;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            //当首次遍历到左右节点都为空的节点的时候说明此节点为最小高度，此时退出循环，flag的作用是告诉外层循环退出
            if (cur.left == null && cur.right == null) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            break;
        }
    }
    return depth;
}
```

力扣实测，此解法耗时较少。





### 力扣 110 平衡二叉树

思路：分别求出左右子树的高度，然后如果差值小于等于1，则返回当前二叉树的高度，否则则返回-1，表示已经不是二叉树了

每次递归前判断左子树或者右子树的值是否为-1；若为-1则直接返回-1；说明该树不平衡

相当于后序遍历

代码如下

```java
private int getDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = getDepth(root.left);
    if (left == -1) {
        return -1;
    }
    int right = getDepth(root.right);
    if (right == -1) {
        return -1;
    }
    int result;
    if (Math.abs(left - right) > 1) {
        result = -1;
    } else {
        result = Math.max(left, right) + 1;
    }
    return result;
}

public boolean isBalanced(TreeNode root) {
    return getDepth(root) != -1;

}
```





### 力扣 257 二叉树的所有路径



递归逻辑是判断当前节点是否为空，若不为空，则将当前节点加入到path路径中

- 如果当前节点是叶子节点，则将之前的`path`加入到`paths`中去，也就是加入到`List<String>`中去

- 如果当前节点不是叶子节点，则将`path`后面加`->`然后递归`getPath()`左子树和右子树



```java
private void getPath(TreeNode root, String path, List<String> paths) {
    if (root != null) {
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        //如果当前节点为叶子节点,说明已经遍历到最底层，加入List<String>中去即可
        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } else {
            //如果当前节点不是叶子节点，继续递归
            sb.append("->");
            getPath(root.left, sb.toString(), paths);
            getPath(root.right, sb.toString(), paths);
        }
    }
}
```



### 力扣404 左子叶之和



此题根据当前节点不能判断是否是左子叶，要根据父节点判断

具体逻辑是父节点左子树不为空，左子树的左右子树都是空的时候，父节点的左子树就是左叶子节点

代码如下：

```java
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int middleValue = 0;
    if (root.left != null && root.left.left == null && root.left.right == null) {
        middleValue = root.left.val;
    }
    return middleValue + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
}
```



迭代写法如下

```java
public int sumOfLeftLeaves2(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    int result = 0;
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();

        if (cur.left != null && cur.left.left == null && cur.left.right == null) {
            result += cur.left.val;
        }
        if (cur.right != null) {
            stack.push(cur.right);
        }
        if (cur.left != null) {
            stack.push(cur.left);
        }
    }
    return result;
}
```





### 力扣513 找树左下角的值

解法：层序遍历，每层遍历的第一个赋值给ans，最后返回的ans就是最左下角的值

代码如下



注意，`LinkedList` 使用`push`的时候相当于栈，使用`offer`的时候相当于队列

```java
public int findBottomLeftValue(TreeNode root) {
    if (root == null) {
        return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans=0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (i == 0) {
                ans = cur.val;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    return ans;
}
```

或者可以先添加右边的再添加左边的，这样就是从右到左层序遍历，最后一个赋值的就是ans；





### 力扣112 路径总和



递归解法
要注意返回true的条件是`targetSum==root.val`而非`targetSum==0`

```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root==null){
        return false;
    }
    //当targetSum==root.val的时候,说明targetSum-root==0,此时路径存在，直接返回true;
    if (root.left==null&&root.right==null&&targetSum==root.val){
        return true;
    }
    return hasPathSum(root.left,targetSum- root.val)||hasPathSum(root.right,targetSum-root.val);
}
```



也可以将所有路径的和保存在一个HashSet中，然后判断是否右targetSum

此解法耗时较长

```java
private void getSum(TreeNode root, int sum, Set<Integer> sums) {
    if (root != null) {
        int newSum = sum;
        if (root.left == null && root.right == null) {
            newSum+=root.val;
            sums.add(newSum);
        } else {
            newSum += root.val;
            getSum(root.left, newSum, sums);
            getSum(root.right, newSum, sums);
        }
    }
}
```







### 力扣106 从中序与后序遍历序列构造二叉树

此题思路是根据postorder数组中的最后一个数字确定当前节点的数值，

- 如果postorder数组为空，则返回null
- 如果postorder数组长度为1，说明该节点为叶子节点，直接返回即可
- 如果不是上面两种情况则对数组进行分割，从中序数组中找到后序数组中最后一个值的索引
- 根据索引将中序数组和后序数组分割成左右各两个
- 构造左子树，将中左，后左传入
- 构造右子树，将中右，后右传入

代码如下

注意分割数组的上下界问题



```java
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder.length == 0) {
        return null;
    }
    int rootValue = postorder[postorder.length - 1];
    TreeNode root = new TreeNode(rootValue);
    if (postorder.length == 1) {
        return root;
    }
    int delimiterIndex;
    for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
        if (inorder[delimiterIndex] == rootValue) {
            break;
        }
    }

    int[] inLeft = new int[delimiterIndex];
    int[] inRight = new int[inorder.length - delimiterIndex - 1];
    System.arraycopy(inorder, 0, inLeft, 0, delimiterIndex);
    System.arraycopy(inorder, delimiterIndex + 1, inRight, 0, inorder.length - delimiterIndex - 1);

    int[] postLeft = new int[delimiterIndex];
    int[] postRight = new int[postorder.length - delimiterIndex - 1];
    System.arraycopy(postorder, 0, postLeft, 0, delimiterIndex);
    System.arraycopy(postorder, delimiterIndex, postRight, 0, postorder.length - delimiterIndex - 1);

    root.left = buildTree(inLeft, postLeft);
    root.right = buildTree(inRight, postRight);
    return root;

}
```







### 力扣700 二叉搜索树中的搜索



此题较简单，用迭代法和递归法各写一遍

递归比较当前节点的数值和目标数值

- 如果当前节点数值比目标数值大，则去节点的左子树寻找
- 如果当前节点数值比目标节点小，则去节点的右子树寻找
- 如果当前节点数值和目标数值相等，则放回当前节点



代码如下

递归法

```java
public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
        return null;
    }
    if (root.val == val) {
        return root;
    } else if (root.val > val) {
        return searchBST(root.left, val);
    } else {
        return searchBST(root.right, val);
    }
}
```



迭代法



如果当前节点数值比目标数值大，左子树进栈，小则右子树进栈，相等返回当前树



```java
public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null) {
        return null;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        if (cur.val == val) {
            return cur;
        }
        if (cur.val > val && cur.left != null) {
            stack.push(cur.left);
        }
        if (cur.val < val && cur.right != null) {
            stack.push(cur.right);
        }
    }
    return null;
}
```

简单的迭代法如下



```java
public TreeNode searchBST3(TreeNode root, int val) {
    while (root != null) {
        if (root.val > val) {
            root = root.left;
        } else if (root.val < val) {
            root = root.right;
        } else {
            return root;
        }
    }
    return null;
}
```

思路就是当节点数值比目标数值大的时候令左子树等于当前节点，小的时候令右子树等于当前节点

相等直接返回即可



### 力扣98 验证二叉搜索树



本题利用了二叉树中序遍历是个递增的有序序列的特征，把前一个遍历的节点存储起来，与当前节点比较，如果当前节点小于前一个节点，则说明不是二叉搜索树

具体代码如下



```java
TreeNode pre;

public boolean isValidBST(TreeNode root) {
    if (root == null) {
        return true;
    }
    boolean left = isValidBST(root.left);
    if (pre != null && root.val <= pre.val) {
        return false;
    }
    //记录前一个节点
    pre = root;
    boolean right = isValidBST(root.right);
    return left && right;
}
```





### 力扣530 二叉搜索树的最小绝对差



和上一题类似

代码如下：

```java
TreeNode pre;
int minAbs=Integer.MAX_VALUE;

public void travel(TreeNode root) {
    if (root == null) {
        return;
    }
    travel(root.left);
    if (pre != null) {
        minAbs = Math.min(root.val - pre.val, minAbs);
    }
    pre = root;
    travel(root.right);
}

public int getMinimumDifference(TreeNode root) {
    travel(root);
    return minAbs;
}
```



### 力扣501 二叉搜索树中的众数

此题定义一个count用于统计树中的某一个元素出现的个数

maxCount用于统计树中出现最多的那个数

定义一个pre指向遍历二叉树时的前一个节点

中序遍历，当前一个节点的数值与当前遍历到的数值相等时，count++；否则将count置1

如果当前count等于maxCount说明此数为众数，加入到List集合中去

如果当前count大于maxCount说明此数是新的众数

令maxCount=count，将队列清空然后再加入当前节点的数值即可

注意一定要先将队列清空再添加元素，因为当出现count大于maxCount的时候，队列里维护的就不再是众数了，应该及时删去，添加上新的众数



代码如下



```java
public int[] findMode(TreeNode root) {
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
        return ans.stream().mapToInt(i -> i).toArray();
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxCount) {
            ans.add(root.val);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(root.val);
        }
        pre = root;
        root = root.right;
    }
    return ans.stream().mapToInt(i -> i).toArray();
}
```





### 力扣236 二叉树的最近公共祖先



此题利用后序遍历，自底向上层层回溯

当遇到root与p或者q相等或者root为空的时候返回root

遍历左子树和右子树，当左子树或者右子树有返回值的时候返回左子树或者右子树

如果左右子树返回值都为空，则返回null



代码如下

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q || root == null) {
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
        return root;
    }
    if (left == null) {
        return right;
    }
    return left;
}
```







### 力扣 235 二叉搜索树的最近公共祖先



此题解法巧妙，前序遍历，如果当前节点在p和q的区间内则直接返回

如果<---[]当前节点比p和q都小，则遍历该树的右子树

如果[]--->当前节点比p和q都大，则遍历该树的左子树

如果[----]则直接返回当前节点

代码如下

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (root.val > q.val && root.val > p.val) {
            root = root.left;
        } else if (root.val < p.val && root.val < q.val) {
            root = root.right;
        } else {
            return root;
        }
    }
    return null;
}
```







### 力扣701 二叉搜索树中的插入操作

此题为搜索二叉搜索树中的插入位置

递归解法为判断当前节点值是否大于给定的值，如果大于则判断当前节点左子树是否为空，若为空则直接插入，若不为空则递归插入左子树，右边类似



需要注意，当树为空的时候，插入的值直接作为该树本身返回

代码如下



```java
public void insert(TreeNode root, int val) {
    if (root == null) {
        return;
    }
    if (root.val > val) {
        if (root.left != null) {
            insert(root.left, val);
        } else {
            root.left = new TreeNode(val);
            return;
        }
    }
    if (root.val < val) {
        if (root.right != null) {
            insert(root.right, val);
        } else {
            root.right = new TreeNode(val);
            return;
        }
    }

}

public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    insert(root, val);
    return root;

}
```



精简解法

```java
public TreeNode insertIntoBST2(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    if (root.val > val) {
        root.left = insertIntoBST2(root.left, val);
    }
    if (root.val < val) {
        root.right = insertIntoBST2(root.right, val);
    }
    return root;
}
```



迭代写法

注意while循环过后`cur`为空 `cu`r的父节点为`pre`也就是要插入的`val`要插在`pre`节点的左子树或者右子树上

判断一下再插入即可

```java
public TreeNode insertIntoBST3(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    TreeNode cur = root;
    TreeNode pre = root;
    while (cur != null) {
        pre = cur;
        if (cur.val > val) {
            cur = cur.left;
        }
        if (cur.val < val) {
            cur = cur.right;
        }
    }
    TreeNode node = new TreeNode(val);
    if (val < pre.val) {
        pre.left =node;
    }else {
        pre.right=node;
    }
    return root;
}
```

