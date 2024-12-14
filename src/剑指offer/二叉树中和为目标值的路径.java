package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为目标值的路径 {

    /**
     * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> lists = pathTarget(root, 22);
        System.out.println(lists);

    }


    static List<List<Integer>> result;
    public static List<List<Integer>> pathTarget(TreeNode root, int target) {
        result = new ArrayList();
        dfs(root, target, new LinkedList());
        return result;
    }

    public static void dfs(TreeNode root, int target, LinkedList<Integer> list) {
        if(null == root) {
            return;
        }
        list.add(root.val);
        target = target - root.val;
        if(0 == target && null == root.left && null == root.right) {
            result.add(new ArrayList(list));
        }
        dfs(root.left, target, list);
        dfs(root.right, target, list);

        list.removeLast();
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
