package leetcode题目.递归回溯;

public class 二叉搜索树与双向链表 {
    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
     * 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，
     * 只能调整树中节点指针的指向。为了让您更好地理解问题，以下面的二叉搜索树为例：
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
     * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     */
    public static void main(String[] args) throws InterruptedException {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node node = treeToDoublyList(root);
        preList(node);
    }

    static Node pre, head;

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

    //遍历结果
    public static void preList(Node node) {
        System.out.println(node.val);
        if (node.left != null) {
            preList(node.left);
        }
        if (node.right != null) {
            preList(node.right);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

    }
}
