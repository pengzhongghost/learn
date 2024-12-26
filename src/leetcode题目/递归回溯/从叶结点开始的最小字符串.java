package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 从叶结点开始的最小字符串 {

    public static void main(String[] args) {
        System.out.println((char) ('0' + 49));
    }

    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode root, String path) {
        if (root == null) {
            return null;
        }
        path = (char) (root.val + 'a') + path;
        if (root.left == null && root.right == null) {
            return path;
        }
        String leftPath = dfs(root.left, path);
        String rightPath = dfs(root.right, path);
        if (leftPath == null) {
            return rightPath;
        }
        if (rightPath == null) {
            return leftPath;
        }
        return leftPath.compareTo(rightPath) < 0 ? leftPath : rightPath;
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
