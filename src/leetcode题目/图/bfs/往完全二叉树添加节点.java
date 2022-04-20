package leetcode题目.图.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 往完全二叉树添加节点 {
    /**
     * https://leetcode-cn.com/problems/NaqhDT/
     * 往完全二叉树添加节点
     * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
     * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
     * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
     * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
     * CBTInserter.get_root() 将返回树的根节点。
     *
     * 示例 1：
     * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
     * 输出：[null,1,[1,2]]
     * 示例 2：
     * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
     * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CBTInserter cbt = new CBTInserter(root);
        cbt.insert(7);
        cbt.insert(8);
        root = cbt.get_root();
    }

    static class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            queue = new LinkedList<>();
            this.root = root;
            queue.offer(root);
            //把节点中没有子节点的放进队列
            while (queue.peek().left != null && queue.peek().right != null) {
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode peek = queue.peek();
            //左边的节点是空的，说明右边的也没有节点
            if (peek.left == null) {
                peek.left = new TreeNode(v);
            } else {
                //右边的是空的，则放在右边
                peek.right = new TreeNode(v);
                queue.poll();
                queue.offer(peek.left);
                queue.offer(peek.right);
            }
            return peek.val;
        }

        public TreeNode get_root() {
            return root;
        }
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
