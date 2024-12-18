package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 寻找二叉搜索树中的目标节点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        int targetNode = findTargetNode(root, 2);
        System.out.println(targetNode);
    }

    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
     */
    static int result = 0;

    static int count;

    public static int findTargetNode(TreeNode root, int cnt) {
        count = cnt;
        dfs(root);
        return result;
    }

    private static void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        dfs(root.right);
        if (count-- == 1) {
            result = root.val;
            return;
        }
        dfs(root.left);
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
