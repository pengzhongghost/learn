package leetcode题目.二叉树;

public class 二叉树的直径 {
    /**
     * https://leetcode-cn.com/problems/diameter-of-binary-tree/
     *二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(4);
        int res = diameterOfBinaryTree(root);
        System.out.println(res);
    }

    static int num = 0;

    //todo 求两个节点路径长度
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return num - 1;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        num = Math.max(num, left + right + 1);
        return Math.max(left, right) + 1;
    }

    //todo 求树高
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        num = Math.max(left, right);
        return num;
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
