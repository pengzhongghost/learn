package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 从上到下打印二叉树II {
    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     * 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode node, int k) {
        if (node != null) {
            if (res.size() <= k) { res.add(new ArrayList<>()); }
            res.get(k).add(node.val);
            dfs(node.left, k + 1);
            dfs(node.right, k + 1);
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
