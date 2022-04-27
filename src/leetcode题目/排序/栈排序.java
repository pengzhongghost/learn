package leetcode题目.排序;

import java.util.PriorityQueue;

public class 栈排序 {
    /**
     * 栈排序
     * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
     * 但不得将元素复制到别的数据结构（如数组）中。
     * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
     * <p>
     * 示例1:
     * 输入：
     * ["SortedStack", "push", "push", "peek", "pop", "peek"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null,null,null,1,null,2]
     * <p>
     * 示例2:
     * 输入：
     * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
     * [[], [], [], [1], [], []]
     * 输出：
     * [null,null,null,null,null,true]
     */
    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    static class SortedStack {

        PriorityQueue<Integer> queue;


        public SortedStack() {
            queue = new PriorityQueue<>();
        }

        public void push(int val) {
            queue.add(val);
        }

        public void pop() {
            queue.poll();
        }

        public int peek() {
            return queue.isEmpty() ? -1 : queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
