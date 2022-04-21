package leetcode题目.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中两个节点之和 {

    /**
     * https://leetcode-cn.com/problems/opLdQZ/
     * 二叉搜索树中两个节点之和
     * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
     * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
     * 假设二叉搜索树中节点的值均唯一。
     *
     * 示例 1：
     * 输入: root = [8,6,10,5,7,9,11], k = 12
     * 输出: true
     * 解释: 节点 5 和节点 7 之和等于 12
     *
     * 示例 2：
     * 输入: root = [8,6,10,5,7,9,11], k = 22
     * 输出: false
     * 解释: 不存在两个节点值之和为 22 的节点
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(11);
        System.out.println(findTarget(root, 22));
    }

    static List<Integer> res;
    static boolean result;

    public static boolean findTarget(TreeNode root, int k) {
        res = new ArrayList<>();
        dfs(root, k);
        return result;
    }

    public static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (res.contains(root.val)) {
            result = true;
        } else {
            res.add(k - root.val);
        }
        dfs(root.left, k);
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
