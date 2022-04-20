package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的右侧视图 {
    /**
     * https://leetcode-cn.com/problems/WNC0Lk/
     * 二叉树的右侧视图
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * <p>
     * 示例 2:
     * 输入: [1,null,3]
     * 输出: [1,3]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        //root.right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    static int floor;
    static List<Integer> res = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private static void dfs(TreeNode root, int k) {
        if (null == root) return;
        if (k > floor) {
            res.add(root.val);
            floor = k;
        }
        //todo 先加右边的
        dfs(root.right, k + 1);
        dfs(root.left, k + 1);
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
