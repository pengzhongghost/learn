package leetcode题目.java基础;

import java.util.Stack;

public class 化栈为队 {
    /**
     * https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
     * 化栈为队
     * 实现一个MyQueue类，该类用两个栈来实现一个队列。
     * <p>
     * 示例：
     * MyQueue queue = new MyQueue();
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    static class MyQueue {

        Stack<Integer> stack01;
        Stack<Integer> stack02;

        public MyQueue() {
            stack01 = new Stack<>();
            stack02 = new Stack<>();
        }

        public void push(int x) {
            stack01.push(x);
        }

        public int pop() {
            if (stack02.isEmpty()) {
                while (!stack01.isEmpty()) {
                    stack02.push(stack01.pop());
                }
            }
            return stack02.pop();
        }

        public int peek() {
            if (stack02.isEmpty()) {
                while (!stack01.isEmpty()) {
                    stack02.push(stack01.pop());
                }
            }
            return stack02.peek();
        }

        public boolean empty() {
            return stack01.isEmpty() && stack02.isEmpty();
        }
    }
}
