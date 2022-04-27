package leetcode题目.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 特定深度节点链表 {
    /**
     * https://leetcode-cn.com/problems/list-of-depth-lcci/
     * 特定深度节点链表
     * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，
     * 则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
     *
     * 示例：
     * 输入：[1,2,3,4,5,null,7,8]
     *
     *         1
     *        /  \
     *       2    3
     *      / \    \
     *     4   5    7
     *    /
     *   8
     *
     * 输出：[[1],[2,3],[4,5,7],[8]]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.right.right = new TreeNode(7);
        ListNode[] result = listOfDepth(root);
        System.out.println(Arrays.toString(result));
    }

    static List<ListNode> result;

    public static ListNode[] listOfDepth(TreeNode tree) {
        result = new ArrayList<>();
        dfs(tree, 0);
        return result.toArray(new ListNode[result.size()]);
    }


    public static void dfs(TreeNode tree, int floor) {
        if (tree == null) {
            return;
        }
        if (result.size() <= floor) {
            result.add(floor, new ListNode(tree.val));
        } else {
            ListNode node = result.get(floor);
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(tree.val);
        }
        dfs(tree.left, floor + 1);
        dfs(tree.right, floor + 1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }


//    static class Node {
//        public int val;
//        public Node prev;
//        public Node next;
//        public Node child;
//    }
//    //遍历结果
//    public static void preList(Node node) {
//        System.out.println(node.val);
//        if (node.left != null) {
//            preList(node.left);
//        }
//        if (node.right != null) {
//            preList(node.right);
//        }
//    }

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
