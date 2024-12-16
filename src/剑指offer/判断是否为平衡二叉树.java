package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 判断是否为平衡二叉树 {

    /**
     * [1,2,2,3,null,null,3,4,null,null,4]
     *      1
     *    2   2
     *  3       3
     *4           4
     * @return
     */

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if(null == root) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
