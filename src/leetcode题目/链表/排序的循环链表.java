package leetcode题目.链表;

public class 排序的循环链表 {
    /**
     * https://leetcode-cn.com/problems/4ueAj6/
     * 排序的循环链表
     * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，
     * 使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
     * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
     * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
     * <p>
     * 示例 1：
     * 输入：head = [3,4,1], insertVal = 2
     * 输出：[3,4,1,2]
     * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。
     * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
     */
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        Node node = insert(head, 2);
        System.out.println(node);
    }

    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        //todo 先找到最小的node
        Node cur = head, next = head.next;
        while (cur.val <= next.val) {
            cur = cur.next;
            next = next.next;
            if (cur == head) {
                break;
            }
        }
        Node realHead = next;
        //todo 然后找到比insertVal大于等于的值
        while (insertVal > next.val) {
            cur = next;
            next = next.next;
            if (next == realHead) break;
        }
        //todo 在这个值的前面一个值插入
        cur.next = new Node(insertVal);
        //todo 处理之后的指针
        cur = cur.next;
        cur.next = next;
        return head;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

}
