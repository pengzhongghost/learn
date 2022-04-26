package leetcode题目.链表;

import java.util.HashSet;
import java.util.Set;

public class 移除重复节点 {
    /**
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     * 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * <p>
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * <p>
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode temp = head;
        while (temp.next != null) {
            ListNode cur = temp.next;
            if (set.add(cur.val)) {
                //todo 此元素不存在
                temp = temp.next;
            } else {
                //todo 存在此数，则跳到下一个
                temp.next = temp.next.next;
            }
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
