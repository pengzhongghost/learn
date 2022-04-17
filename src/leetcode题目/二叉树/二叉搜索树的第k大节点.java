package leetcode题目.二叉树;

public class 二叉搜索树的第k大节点 {
    /**
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     *  二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     *
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        TreeNode root02 = new TreeNode(1);
        System.out.println(kthLargest(root02, 1));
    }

    static int count = 0, result;

    public static int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        count++;
        if (k == count) {
            result = root.val;
        }
        dfs(root.left, k);
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
