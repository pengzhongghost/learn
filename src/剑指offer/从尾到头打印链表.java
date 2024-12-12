package 剑指offer;

public class 从尾到头打印链表 {

    /**
     * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     *
     * @param head
     * @return
     */
    public int[] reverseBookList(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = head.val;
            head = head.next;
        }
        return arr;
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
