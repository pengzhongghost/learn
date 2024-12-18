package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 计算二叉树的深度 {

    /**
     * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/
     */
    public int calculateDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
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

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
