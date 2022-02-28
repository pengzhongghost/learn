package leetcode题目.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的最大深度 {
    /**
     * 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth(null));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void dfs(TreeNode root) {

    }

    static int depth = 0;

    public static int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        queue.push(rootList);
        while (!queue.isEmpty()) {
            List<TreeNode> popList = queue.pop();
            List<TreeNode> pushList = new ArrayList<>();
            if (popList == null || popList.size() == 0) {
                continue;
            }
            depth++;
            for (TreeNode treeNode : popList) {
                if (treeNode == null) {
                    continue;
                }
                if (treeNode.left != null) {
                    pushList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    pushList.add(treeNode.right);
                }
            }
            queue.push(pushList);
        }
        return depth;
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
