package 剑指offer;

public class 最小栈 {

    /**
     * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
     */

    Node head;
    /** initialize your data structure here. */
    public 最小栈() {
    }

    public void push(int x) {
        if(null == head) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.minNum), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.num;
    }

    public int getMin() {
        return head.minNum;
    }

    class Node {
        private int num;
        private int minNum;
        private Node next;

        public Node(int num, int minNum, Node next) {
            this.num = num;
            this.minNum = minNum;
            this.next = next;
        }

    }

}
