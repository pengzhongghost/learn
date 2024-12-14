package 剑指offer;

public class 子结构判断 {

    /**
     * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B || null == A) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A || A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
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
