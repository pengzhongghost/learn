package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    /**
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点
     * 路径总和等于给定目标和的路径。叶子节点 是指没有子节点的节点。
     * <p>
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        System.out.println(pathSum(root, 22));
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, new ArrayList<>());
        return result;
    }

    public static void dfs(TreeNode root, int target, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        //todo 此处之所以要用target - root.val == 0，是因为如果是target==0的话，此时的root已经为null了
        if (target - root.val == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(res));
        }
        dfs(root.left, target - root.val, res);
        dfs(root.right, target - root.val, res);
        res.remove(res.size() - 1);
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
