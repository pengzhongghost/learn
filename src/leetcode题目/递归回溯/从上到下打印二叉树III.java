package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 从上到下打印二叉树III {
    /**
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [20,9],
     * [15,7]
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
            if (res.size() <= k) {
                res.add(new ArrayList<>());
            }
            if (k % 2 == 0) {
                res.get(k).add(node.val);
            } else {
                res.get(k).add(0, node.val);
            }
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
