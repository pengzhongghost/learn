package 剑指offer;

import leetcode题目.二叉树.二叉树的层序遍历;
import leetcode题目.递归回溯.从上到下打印二叉树III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 彩灯装饰记录III {

    /**
     * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/description/
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(17);
        root.right = new TreeNode(21);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(6);
        System.out.println(decorateRecord(root));
    }

    /**
     * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/description/
     */
    public static List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        int index = 1;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> nums = new ArrayList();
            int curSize = queue.size();
            index++;
            for(int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                nums.add(node.val);
                if(index % 2 == 0) {
                    if(null != node.right) {
                        queue.offer(node.right);
                    }
                    if(null != node.left) {
                        queue.offer(node.left);
                    }
                } else {
                    if(null != node.left) {
                        queue.offer(node.left);
                    }
                    if(null != node.right) {
                        queue.offer(node.right);
                    }
                }
            }
            result.add(nums);
        }
        return result;
    }

    static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
