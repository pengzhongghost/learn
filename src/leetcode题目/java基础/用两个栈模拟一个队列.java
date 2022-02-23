package leetcode题目.java基础;

import java.util.LinkedList;
import java.util.Stack;

public class 用两个栈模拟一个队列 {
    /**
     * todo 队列应该是先进先出的，
     *      而栈是先进后出的，怎么用两个栈模拟队列
     */
    public static void main(String[] args) {

    }
}

class CQueue {

    private final Stack<Integer> stack01 = new Stack<>();
    private final Stack<Integer> stack02 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack01.push(value);
    }

    public int deleteHead() {
        if (stack02.isEmpty()) {
            if (stack01.isEmpty()) {
                return -1;
            }
            while (!stack01.isEmpty()) {
                stack02.push(stack01.pop());
            }
        }
        return stack02.pop();
    }
}

class CQueue02 {

    private final LinkedList<Integer> stack01 = new LinkedList<>();
    private final LinkedList<Integer> stack02 = new LinkedList<>();

    public CQueue02() {

    }

    public void appendTail(int value) {
        stack01.add(value);
    }

    public int deleteHead() {
        if (stack02.isEmpty()) {
            if (stack01.isEmpty()) {
                return -1;
            }
            while (!stack01.isEmpty()) {
                stack02.push(stack01.pop());
            }
        }
        return stack02.pop();
    }
}