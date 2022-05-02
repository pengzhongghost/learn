package leetcode题目.链表;

public class 删除链表中的节点 {
    /**
     * 删除链表中的节点
     * 将自己完全变成另一个人，再杀了那个人就行了。
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
