package leetcode题目.链表;

public class 旋转链表{
    /**
     * https://leetcode-cn.com/problems/rotate-list/
     * 旋转链表
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = rotateRight(head, 2);
        System.out.println(result);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int length = 1;
        ListNode tail = head;
        //todo 求出链表长度
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        //todo k%length即为需要移动的位置
        k %= length;
        ListNode p = head;
        for (int i = 0; i < length - k - 1; i++) {
            p = p.next;
        }
        //todo 尾节点指向头节点
        tail.next = head;
        //头节点为p的下一个
        head = p.next;
        p.next = null;
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
