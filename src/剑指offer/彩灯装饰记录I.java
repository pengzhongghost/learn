package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 彩灯装饰记录I {

    /**
     * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。
     * 请按照从 左 到 右 的顺序返回每一层彩灯编号。
     */

    public int[] decorateRecord(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        List<Integer> result = new ArrayList();
        LinkedList<TreeNode> list = new LinkedList();
        list.push(root);
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            result.add(node.val);
            if (null != node.left) {
                list.offer(node.left);
            }
            if (null != node.right) {
                list.offer(node.right);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
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
