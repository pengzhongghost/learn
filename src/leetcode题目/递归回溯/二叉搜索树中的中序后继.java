package leetcode题目.递归回溯;

public class 二叉搜索树中的中序后继 {
    /**
     * https://leetcode-cn.com/problems/P5rCT8/
     * 二叉搜索树中的中序后继
     * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
     * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
     *
     * 示例 1：
     * 输入：root = [2,1,3], p = 1
     * 输出：2
     * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNode treeNode = inorderSuccessor(root, root.left.right);
        System.out.println();
    }

    static TreeNode preNode;
    static TreeNode resNode;

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return resNode;
    }

    private static void dfs(TreeNode node, TreeNode p) {
        if (null == node) {
            return;
        }
        dfs(node.left, p);
        if (preNode == p) {
            resNode = node;
        }
        preNode = node;
        dfs(node.right, p);
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
