package 剑指offer;

public class 删除链表的节点 {

    /**
     * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(val == head.val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode temp = head.next;
        while(null != temp) {
            if(val == temp.val) {
                pre.next = temp.next;
            }
            pre = temp;
            temp = temp.next;
        }
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
