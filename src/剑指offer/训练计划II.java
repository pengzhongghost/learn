package 剑指offer;

public class 训练计划II {

    /**
     * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
