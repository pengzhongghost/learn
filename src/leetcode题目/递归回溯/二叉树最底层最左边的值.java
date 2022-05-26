package leetcode题目.递归回溯;

public class 二叉树最底层最左边的值 {
    /**
     * https://leetcode-cn.com/problems/LwUNpT/
     * 二叉树最底层最左边的值
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * 假设二叉树中至少有一个节点。
     * <p>
     * 示例 1:
     * 输入: root = [2,1,3]
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        //TreeNode root = new TreeNode(1);
        System.out.println(findBottomLeftValue(root));
    }

    static int floor;
    static int res;

    public static int findBottomLeftValue(TreeNode root) {
        //为了下面k>floor写入根节点的数据
        dfs(root, 1);
        return res;
    }

    private static void dfs(TreeNode root, int k) {
        if (null == root) return;
        dfs(root.left, k + 1);
        if (k > floor) {
            res = root.val;
            floor = k;
        }
        dfs(root.right, k + 1);
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
