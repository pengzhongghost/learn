package leetcode题目.二叉树;

public class 填充每个节点的右节点 {
    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
     * 则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有next 指针都被设置为 NULL。
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     */
    public static void main(String[] args) {

    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null && root.next.left != null) {
            root.right.next = root.next.left;
        }
        if (root.left != null) {
            connect(root.left);
        }
        if (root.right != null) {
            connect(root.right);
        }
        return root;
    }

    //遍历
    public static void preList(Node node) {
        System.out.println(node.val);
        if (node.left != null) {
            preList(node.left);
        }
        if (node.right != null) {
            preList(node.right);
        }
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}