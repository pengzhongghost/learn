package leetcode题目.二叉树;

public class 对称的二叉树 {
    /**
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
     * 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(3);
        node01.left = new TreeNode(4);
        node01.right = new TreeNode(5);
        node01.left.left = new TreeNode(1);
        node01.left.right = new TreeNode(2);
        preList(node01);
        System.out.println(isSymmetric(node01));
    }

    public static boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void preList(TreeNode node) {
        System.out.println(node.val);
        if (node.left != null) {
            preList(node.left);
        }
        if (node.right != null) {
            preList(node.right);
        }
    }

}
