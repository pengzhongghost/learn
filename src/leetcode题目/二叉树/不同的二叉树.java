package leetcode题目.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 不同的二叉树 {
    /**
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从
     * 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     *
     * @param args
     */
    public static void main(String[] args) {
        不同的二叉树 temp = new 不同的二叉树();
        List<TreeNode> treeNodes = temp.generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        List<TreeNode> trees = generateTrees(1, n);
        return trees;
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start >= end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            //生成左子树
            List<TreeNode> leftList = generateTrees(start, i - 1);
            //生成右子树
            List<TreeNode> rightList = generateTrees(i + 1, end);
            TreeNode treeNode = new TreeNode(i);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    treeNode.left = left;
                    treeNode.right = right;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
