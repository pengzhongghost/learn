package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengzhong
 * @since 2024/12/23
 */
public class 二叉树的所有路径 {

    /**
     * https://leetcode.cn/problems/binary-tree-paths/?envType=problem-list-v2&envId=backtracking
     */

    List<String> result = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }

    private void dfs(TreeNode root, String path) {
        if(null == root) {
            return;
        }
        if(null == root.left && null == root.right) {
            path = path + root.val;
            result.add(path);
            return;
        }
        dfs(root.left, path + root.val + "->");
        dfs(root.right, path + root.val + "->");
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
