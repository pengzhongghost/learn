package leetcode题目.java基础;

public class 删除链表的节点 {
    public static void main(String[] args) {
        ListNode root = new ListNode(-3);
        root.next = new ListNode(5);
        root.next.next = new ListNode(-99);
        ListNode node = deleteNode(root, -3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
