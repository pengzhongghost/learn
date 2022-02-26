package leetcode题目.链表;

public class 两数相加 {

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
        //2 4 3
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);
        //5 6 4
        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(first, second);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int before = 0;
        while (l1 != null || l2 != null || before != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + before;
            before = sum / 10;
            ListNode nextNode = new ListNode(sum % 10);
            cur.next = nextNode;
            cur = nextNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    static class ListNode {
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
}