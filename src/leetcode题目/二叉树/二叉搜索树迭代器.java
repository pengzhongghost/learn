package leetcode题目.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树迭代器 {
    /**
     * https://leetcode-cn.com/problems/kTOapQ/
     * 二叉搜索树迭代器
     * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
     * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root
     * 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
     * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
     * int next()将指针向右移动，然后返回指针处的数字。
     * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
     * 可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
     * <p>
     * 示例：
     * 输入
     * inputs = ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
     * inputs = [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
     * 输出
     * [null, 3, 7, true, 9, true, 15, true, 20, false]
     * <p>
     * 解释
     * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
     * bSTIterator.next();    // 返回 3
     * bSTIterator.next();    // 返回 7
     * bSTIterator.hasNext(); // 返回 True
     * bSTIterator.next();    // 返回 9
     * bSTIterator.hasNext(); // 返回 True
     * bSTIterator.next();    // 返回 15
     * bSTIterator.hasNext(); // 返回 True
     * bSTIterator.next();    // 返回 20
     * bSTIterator.hasNext(); // 返回 False
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bst = new BSTIterator(root);
        System.out.println(bst.next());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
    }

    static class BSTIterator {

        Queue<Integer> queue;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            dfs(root);
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            queue.offer(node.val);
            dfs(node.right);
        }

        public int next() {
            return queue.poll();
        }


        public boolean hasNext() {
            return !queue.isEmpty();
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
