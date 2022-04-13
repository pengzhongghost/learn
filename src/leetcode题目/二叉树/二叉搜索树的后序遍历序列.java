package leetcode题目.二叉树;

import java.util.Stack;

public class 二叉搜索树的后序遍历序列 {
    /**
     * 二叉搜索树的后序遍历序列
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * <p>
     * 参考以下这颗二叉搜索树：
     * 5
     * / \
     * 2   6
     * / \
     * 1   3
     * <p>
     * 示例 1：
     * 输入: [1,6,3,2,5]
     * 输出: false
     * <p>
     * 示例 2：
     * 输入: [1,3,2,6,5]
     * 输出: true
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
     */
    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        System.out.println(verifyPostorder(postorder));
    }

    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
