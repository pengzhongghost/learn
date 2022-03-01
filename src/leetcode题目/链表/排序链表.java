package leetcode题目.链表;

public class 排序链表 {
    /**
     * 排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * https://leetcode-cn.com/problems/sort-list/
     */
    public static void main(String[] args) {

    }

    //todo 将一个链表拆分为两个
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next.next, l, r;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        r = sortList(slow.next);
        slow.next = null;
        l = sortList(head);
        return mergeList(l, r);
    }

    //todo 归并算法
    public static ListNode mergeList(ListNode left, ListNode right) {
        ListNode temp = new ListNode();
        ListNode t = temp;
        while (left != null && right != null) {
            if (left.val < right.val) {
                t.next = left;
                left = left.next;
            } else {
                t.next = right;
                right = right.next;
            }
            t = t.next;
        }
        t.next = left == null ? right : left;
        return temp.next;
    }

    static class ListNode {
        int      val;
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
