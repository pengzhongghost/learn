package leetcode题目.动态规划;

public class 最佳观光组合 {
    /**
     * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，并且两个景点i 和j之间的 距离 为j - i。
     * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
     * 返回一对观光景点能取得的最高分。
     * <p>
     * 示例 1：
     * 输入：values = [8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
     * <p>
     * 示例 2：
     * 输入：values = [1,2]
     * 输出：2
     */
    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(values));
    }

    //通过mx记录values[i]+i的最大值
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
