package 剑指offer;

public class 训练计划IV {

    /**
     * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/description/
     */
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = trainningPlan(l1.next, l2);
            return l1;
        } else {
            l2.next = trainningPlan(l1, l2.next);
            return l2;
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

}
