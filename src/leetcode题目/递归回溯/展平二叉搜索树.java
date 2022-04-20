package leetcode题目.递归回溯;

public class 展平二叉搜索树 {
    /**
     * https://leetcode-cn.com/problems/NYBBNL/
     * 展平二叉搜索树
     * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
     * 并且每个节点没有左子节点，只有一个右子节点。
     * <p>
     * 示例 1：
     * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        System.out.println(increasingBST(root));
    }

    static TreeNode preNode;

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode resNode = new TreeNode(-1);
        preNode = resNode;
        dfs(root);
        return resNode.right;
    }

    private static void dfs(TreeNode node) {
        if (null == node) {
            return;
        }
        dfs(node.left);
        preNode.right = node;
        node.left = null;
        preNode = node;
        dfs(node.right);
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
