package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 训练计划V {

    /**
     * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/description/
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB) {
            curA = null == curA ? headB : curA.next;
            curB = null == curB ? headA : curB.next;
        }
        return curA;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

}
