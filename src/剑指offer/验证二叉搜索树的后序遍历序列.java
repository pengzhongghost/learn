package 剑指offer;

import java.util.Stack;

public class 验证二叉搜索树的后序遍历序列 {

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
