package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 彩灯装饰记录II {

    /**
     * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/description/
     */
    public List<List<Integer>> decorateRecord(TreeNode root) {
        if (null == root) {
            return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList();
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
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
