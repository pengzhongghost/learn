package leetcode题目.双指针;

public class 删除链表的倒数第n个节点 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        ListNode node06 = new ListNode(6);
        head.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        head = removeNthFromEnd(head, 2);
        System.out.println(head.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //头节点的前一个节点,用于最后返回头节点
        ListNode pre = new ListNode(0, head);
        ListNode first = head;
        ListNode second = pre;
        //第一个指针先走n步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //第一个指针和第二个指针相差n步
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //第一个指针走到最后则第二个指针走到要删除的元素的前一个位置
        second.next = second.next.next;
        return pre.next;
    }
}
