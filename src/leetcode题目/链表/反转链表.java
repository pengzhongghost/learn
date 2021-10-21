package leetcode题目.链表;

import java.util.Stack;

public class 反转链表 {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(l1);
        list(result);
    }

    //递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    //让后一个节点指向前面一个节点
    public static ListNode reverseList02(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = next;
            cur = cur.next;
        }
        return prev;
    }

    //栈
    public static ListNode reverseList01(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = new ListNode();
        head = result;
        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        //最前面一个元素的next置为空
        head.next = null;
        return result.next;
    }

    public static void list(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
