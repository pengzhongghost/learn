package leetcode题目.随机;

import java.util.TreeMap;

public class 按权重生成随机数 {
    /**
     * https://leetcode-cn.com/problems/cuyjEf/
     * 按权重生成随机数
     * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，
     * 它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
     * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），
     * 而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
     * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
     * <p>
     * 示例 1：
     * 输入：
     * inputs = ["Solution","pickIndex"]
     * inputs = [[[1]],[]]
     * 输出：
     * [null,0]
     * 解释：
     * Solution solution = new Solution([1]);
     * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
     */
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    static class Solution {

        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public Solution(int[] w) {
            for (int i = 0; i < w.length; i++) {
                map.put(sum, i);
                sum += w[i];
            }
        }

        public int pickIndex() {
            int r = (int) (Math.random() * sum);
            return map.get(map.floorKey(r));
        }

    }
}
