package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 二叉树每层的最大值 {
    /**
     * https://leetcode-cn.com/problems/hPov7L/
     * 二叉树每层的最大值
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     *
     * 示例1：
     * 输入: root = [1,3,2,5,3,null,9]
     * 输出: [1,3,9]
     * 解释:
     *           1
     *          / \
     *         3   2
     *        / \   \
     *       5   3   9
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> res = largestValues(root);
        System.out.println(res);
    }

    private static List<Integer> res = new ArrayList<>();

    public static List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public static void dfs(TreeNode root, int k) {
        if (root != null) {
            if (res.size() <= k) res.add(k, root.val);
            res.set(k, Math.max(res.get(k), root.val));
            dfs(root.left, k + 1);
            dfs(root.right, k + 1);
        }
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
