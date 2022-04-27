package leetcode题目.二叉树;

public class 最小高度树 {
    /**
     * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
     * 最小高度树
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
     *
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *           0
     *          / \
     *        -3   9
     *        /   /
     *      -10  5
     */
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public static TreeNode dfs(int[] nums, int l, int r) {
        if (l >= r) return null;
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid);
        root.right = dfs(nums, mid + 1, r);
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
