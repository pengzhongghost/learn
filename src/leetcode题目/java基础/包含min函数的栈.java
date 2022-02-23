package leetcode题目.java基础;

public class 包含min函数的栈 {
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