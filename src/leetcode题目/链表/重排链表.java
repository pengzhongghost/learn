package leetcode题目.链表;

public class 重排链表 {
    /**
     * https://leetcode-cn.com/problems/LGjMqU/
     * 重排链表
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     *  L0 → L1 → … → Ln-1 → Ln
     * 请将其重新排列后变为：
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1:
     * 输入: head = [1,2,3,4]
     * 输出: [1,4,2,3]
     */
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        ListNode midNode = midList(head);
        ListNode l2 = midNode.next;
        midNode.next = null;
        l2 = reverse(l2);
        mergeList(head, l2);
    }

    public static ListNode midList(ListNode node) {
        ListNode fast = node, slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return next;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode temp01, temp02;
        while (l1 != null && l2 != null) {
            temp01 = l1.next;
            temp02 = l2.next;
            l1.next = l2;
            l1 = temp01;
            l2.next = l1;
            l2 = temp02;
        }
    }
}
