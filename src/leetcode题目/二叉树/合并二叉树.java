package leetcode题目.二叉树;

public class 合并二叉树 {
    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
     * 否则不为NULL 的节点将直接作为新二叉树的节点。
     *
     */
    public static void main(String[] args) {
        TreeNode root01 = new TreeNode(1);
        TreeNode tree02 = new TreeNode(2);
        TreeNode tree03 = new TreeNode(3);
        TreeNode tree04 = new TreeNode(5);
        root01.left = tree03;
        root01.right = tree02;
        tree03.left = tree04;
        TreeNode root02 = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode child01 = new TreeNode(4);
        TreeNode child02 = new TreeNode(7);
        root02.left = left;
        root02.right = right;
        left.right = child01;
        right.right = child02;
        TreeNode treeNode = mergeTrees(root01, root02);
        preList(treeNode);
    }

    //深度优先搜索
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
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
class TreeNode {
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