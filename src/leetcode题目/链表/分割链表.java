package leetcode题目.链表;

public class 分割链表 {
    /**
     * https://leetcode-cn.com/problems/partition-list-lcci/
     * 分割链表
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在
     * 大于或等于 x 的节点之前。
     * 你不需要 保留 每个分区中各节点的初始相对位置。
     * <p>
     * 示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * <p>
     * 示例 2：
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
