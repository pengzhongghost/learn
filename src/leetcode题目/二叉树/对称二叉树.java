package leetcode题目.二叉树;

public class 对称二叉树 {
    /**
     * 对称二叉树
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null) {
            return false;
        }
        if (rightNode == null) {
            return false;
        }
        if (leftNode.val == rightNode.val) {
            if (!dfs(leftNode.right, rightNode.left)) {
                return false;
            }
            return dfs(leftNode.left, rightNode.right);
        }
        return false;
    }

    static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
