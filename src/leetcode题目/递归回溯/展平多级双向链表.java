package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 展平多级双向链表 {
    /**
     * https://leetcode-cn.com/problems/Qv1Da2/
     * 展平多级双向链表
     */
    public static void main(String[] args) {

    }

    static List<Node> list = new ArrayList<>();

    public static Node flatten(Node head) {
        dfs(head);
        for (int i = 0; i < list.size()-1; i++) {
            Node prev = list.get(i);
            Node next = list.get(i + 1);
            prev.next = next;
            next.prev = prev;
            prev.child = null;
        }
        return head;
    }

    public static void dfs(Node node) {
        if (node == null) return;
        list.add(node);
        dfs(node.child);
        dfs(node.next);
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
