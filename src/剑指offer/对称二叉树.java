package 剑指offer;

public class 对称二叉树 {

    /**
     * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/description/
     */
    public boolean checkSymmetricTree(TreeNode root) {
        if(null == root) {
            return true;
        }
        return checkSymmetricTree(root.left, root.right);
    }

    private boolean checkSymmetricTree(TreeNode left, TreeNode right) {
        if(null == left && null == right) {
            return true;
        }
        if(null == left || null == right) {
            return false;
        }
        return left.val == right.val
                && checkSymmetricTree(left.left, right.right)
                && checkSymmetricTree(left.right, right.left);
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
