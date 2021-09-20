package leetcode题目.链表;

public class 合并两个有序链表 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        list(listNode);
    }

    //简单写法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode res = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return result.next;
    }

    //递归
    public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //复杂
    public static ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        ListNode preHead01 = new ListNode();
        ListNode preHead02 = new ListNode();
        preHead01.next = l1;
        preHead02.next = l2;
        ListNode result = new ListNode();
        ListNode res = result;
        while (preHead01.next != null && preHead02.next != null) {
            if (preHead01.next.val < preHead02.next.val) {
                result.next = new ListNode(preHead01.next.val);
                preHead01 = preHead01.next;
            } else {
                result.next = new ListNode(preHead02.next.val);
                preHead02 = preHead02.next;
            }
            result = result.next;
        }
        while (preHead01.next != null) {
            result.next = preHead01.next;
            result = result.next;
            preHead01 = preHead01.next;
        }
        while (preHead02.next != null) {
            result.next = preHead02.next;
            result = result.next;
            preHead02 = preHead02.next;
        }
        return res.next;
    }

    public static void list(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
