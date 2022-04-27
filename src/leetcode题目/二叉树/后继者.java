package leetcode题目.二叉树;

public class 后继者 {
    /**
     * https://leetcode-cn.com/problems/successor-lcci/
     * 后继者
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     *
     * 示例 1:
     * 输入: root = [2,1,3], p = 1
     *   2
     *  / \
     * 1   3
     *
     * 输出: 2
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], p = 6
     *
     *       5
     *      / \
     *     3   6
     *    / \
     *   2   4
     *  /
     * 1
     *
     * 输出: null
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        TreeNode p = new TreeNode(1);
        root.left.left.left = p;
        TreeNode treeNode = inorderSuccessor(root, p);
        System.out.println(treeNode);
    }

    static TreeNode preNode;
    static TreeNode resultNode;

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        preNode = new TreeNode();
        dfs(root, p);
        return resultNode;
    }

    public static void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (preNode == p) {
            resultNode = root;
            //todo 防止回溯的时候被赋上其他值
            preNode = resultNode;
            return;
        }
        preNode = root;
        dfs(root.right, p);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
