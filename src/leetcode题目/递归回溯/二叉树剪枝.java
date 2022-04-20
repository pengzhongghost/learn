package leetcode题目.递归回溯;

public class 二叉树剪枝 {

    /**
     * https://leetcode-cn.com/problems/pOCWxh/
     * 二叉树剪枝
     * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
     * 节点 node 的子树为 node 本身，以及所有 node 的后代。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        TreeNode treeNode = pruneTree(root);
        System.out.println(treeNode);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }
        return root;
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
