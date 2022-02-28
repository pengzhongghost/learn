package leetcode题目.二叉树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {
    /**
     * 从前序与中序遍历序列构造二叉树
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
     * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * <p>
     * 示例 1:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * <p>
     * 示例 2:
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        preorder = new int[]{1, 2, 3};
        //preorder = new int[] {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        inorder = new int[]{3, 2, 1};
        //inorder = new int[] {4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        preList(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, map);
    }

    static int rootIndex = 0;

    public static TreeNode buildTree(int[] preorder, int left, int right, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        //此处需要一个新的变量，rootindex会自增
        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        rootIndex++;
        root.left = buildTree(preorder, left, map.get(rootVal) - 1, map);
        root.right = buildTree(preorder, map.get(rootVal) + 1, right, map);
        return root;
    }

    public static void preList(TreeNode treeNode) {
        System.out.println(treeNode.val);
        if (treeNode.left != null) {
            preList(treeNode.left);
        }
        if (treeNode.right != null) {
            preList(treeNode.right);
        }
    }

    public static TreeNode buildTree02(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; ++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if (preorder[0] == inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
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
