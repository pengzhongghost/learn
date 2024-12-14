package 剑指offer;

public class 翻转二叉树 {

    /**
     * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/
     */
    public TreeNode flipTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        flipTree(root.left);
        flipTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
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
