package 剑指offer;

public class 训练计划III {

    /**
     * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
     */
    public ListNode trainningPlan(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = trainningPlan(head.next);
        head.next.next = head;
        head.next = null;
        return next;
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
