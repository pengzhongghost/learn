package leetcode题目.链表;

public class 回文链表 {
    /**
     * 回文链表
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：head = [1,2,2,1]
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(2);
        root.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(root));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverse(slow);
        ListNode temp = head;
        while (temp != slow) {
            if (temp.val != reverse.val) {
                return false;
            }
            temp = temp.next;
            reverse = reverse.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }

    static class ListNode {
        int      val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
