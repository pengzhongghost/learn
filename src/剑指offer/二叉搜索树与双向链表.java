package 剑指offer;

public class 二叉搜索树与双向链表 {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
     */
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(null == root) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if(null == node) {
            return;
        }
        dfs(node.left);
        node.left = pre;
        if(null != pre) {
            pre.right = node;
        } else {
            head = node;
        }
        pre = node;
        dfs(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
