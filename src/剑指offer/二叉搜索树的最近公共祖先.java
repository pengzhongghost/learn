package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/19
 */
public class 二叉搜索树的最近公共祖先 {

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root) {
            return null;
        }
        if(p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(null != left && null != right) {
            return root;
        } else if(null != left) {
            return left;
        } else if(null != right) {
            return right;
        } else {
            return null;
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
