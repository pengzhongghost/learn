package leetcode题目.递归回溯;

public class 路径总和III {
    /**
     * https://leetcode-cn.com/problems/path-sum-iii/
     * 路径总和 III
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        int pathSum = pathSum(root, 8);
        System.out.println(pathSum);
    }

    public static int pathSum02(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root,targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right,targetSum);
        return result;
    }

    public static void dfs02(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val) {
            result++;
        }
        targetSum-=root.val;
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    static int result = 0;

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return result;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            result++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
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
