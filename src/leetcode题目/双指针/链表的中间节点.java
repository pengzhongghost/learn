package leetcode题目.双指针;

public class 链表的中间节点 {
    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3
     */
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        //ListNode node06 = new ListNode(6);
        head.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        //node05.next = node06;
        ListNode mid = getMid(head);
        System.out.println(mid.val);
    }
    /**
     * 快慢指针
     * 一个指针两步两步的走，另一个一步一步的走
     * 当走两边的指针走完之后，走一步的就走到中间节点了
     */
    public static ListNode getMid(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
