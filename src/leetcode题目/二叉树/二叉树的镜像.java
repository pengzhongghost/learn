package leetcode题目.二叉树;

public class 二叉树的镜像 {
    /**
     * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     * 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * 镜像输出：
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     * <p>
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     */
    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(3);
        node01.left = new TreeNode(4);
        node01.right = new TreeNode(5);
        node01.left.left = new TreeNode(1);
        node01.left.right = new TreeNode(2);
        preList(node01);
        TreeNode node = mirrorTree(node01);
        preList(node);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //遍历结果
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
