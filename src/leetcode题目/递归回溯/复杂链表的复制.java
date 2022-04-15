package leetcode题目.递归回溯;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {
    /**
     * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
     * 复杂链表的复制
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next
     * 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     * <p>
     * 示例 1：
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * <p>
     * 示例 2：
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * <p>
     * 示例 3：
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * <p>
     * 示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     */
    public static void main(String[] args) throws InterruptedException {

    }

    private static Map<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        // 终止条件next给过来的node为null；
        if (head == null) {
            return null;
        }
        // 中间处理方法
        // 1. 递归创建节点到最后一个节点，并吧所有创建的节点保存在map中；
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        // 2. 因为递归过程中会创建所有的节点，所以回溯过程中直接进行newNode.random赋值
        newNode.random = map.get(head.random);
        return newNode;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
