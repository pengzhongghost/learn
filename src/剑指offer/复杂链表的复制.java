package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    /**
     * https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
     */

    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        if(null == head) {
            return null;
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = map.get(head.random);
        return newNode;
    }

    class Node {
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
