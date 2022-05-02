package leetcode题目.链表;

public class 奇偶链表 {
    /**
     * https://leetcode-cn.com/problems/odd-even-linked-list/
     * 奇偶链表
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * <p>
     * 示例 1:
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = oddEvenList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode next = head.next;
        while (fast != null && fast.next != null) {
            slow.next = fast.next;
            slow = slow.next;
            fast.next = slow.next;
            fast = fast.next;
        }
        slow.next = next;
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
