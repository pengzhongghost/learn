package leetcode题目.二叉树;

public class 把二叉搜索树转换为累加树 {
    /**
     * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
     * 把二叉搜索树转换为累加树
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(4);
        TreeNode treeNode = convertBST(root);
    }

    static int num = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //todo 先从柚子树开始
        convertBST(root.right);
        root.val += num;
        num = root.val;
        convertBST(root.left);
        return root;
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
