package leetcode题目.递归回溯;

public class 二叉搜索树中第K小的元素 {
    /**
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
     * 二叉搜索树中第K小的元素
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
     * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     * <p>
     * 示例 1：
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(kthSmallest(root, 1));
    }

    static int count = 0;
    static int res = -1;

    public static int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }


    public static void dfs(TreeNode root, int k) {
        if (root == null || res != -1) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        dfs(root.right, k);
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
