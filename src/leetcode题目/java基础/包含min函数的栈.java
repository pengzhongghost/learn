package leetcode题目.java基础;

import java.util.Stack;

public class 包含min函数的栈 {
    /**
     * 155. 最小栈
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * 实现 MinStack 类:
     * <p>
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
     * int getMin() 获取堆栈中的最小元素。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     * <p>
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     * <p>
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     * https://leetcode-cn.com/problems/min-stack/
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    //两个栈实现
    static class MinStack02 {

        Stack<Integer> data;
        Stack<Integer> minStack;

        public MinStack02() {
            data = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            minStack.push(Math.min(minStack.peek(), val));
            data.push(val);
        }

        public void pop() {
            minStack.pop();
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

class MinStack {

    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.num;
    }

    public int min() {
        return head.min;
    }

    static class Node {
        public int num;
        public int min;
        public Node next;

        public Node(int num, int min, Node next) {
            this.num = num;
            this.min = min;
            this.next = next;
        }
    }

}