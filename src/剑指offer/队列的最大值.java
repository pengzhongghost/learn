package 剑指offer;

public class 队列的最大值 {

    /**
     * 没过测试用例，但是是可行的
     * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/description/
     */

    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.add(45);
        System.out.println(checkout.remove());
        System.out.println(checkout.get_max());
    }

    static class Checkout {

        Node head;
        Node tail;

        public Checkout() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get_max() {
            if (null == head || tail == head.next) {
                return -1;
            }
            return head.next.maxValue;
        }

        public void add(int value) {
            int maxValue;
            if (tail == head.next) {
                maxValue = value;
            } else {
                maxValue = Math.max(head.next.value, value);
            }
            Node node = new Node(value, maxValue);
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public int remove() {
            if (null == tail || head == tail.pre) {
                return -1;
            }
            int value = tail.pre.value;
            tail = tail.pre;
            tail.next = null;
            return value;
        }

        static class Node {
            int maxValue;
            int value;
            Node next;
            Node pre;

            public Node() {
            }

            public Node(int value, int maxValue) {
                this.value = value;
                this.maxValue = maxValue;
            }

        }

    }

}
