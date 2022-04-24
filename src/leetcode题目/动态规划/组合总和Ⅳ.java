package leetcode题目.动态规划;

public class 组合总和Ⅳ {
    /**
     * 组合总和Ⅳ
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * 题目数据保证答案符合 32 位整数范围。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * <p>
     * 示例 2：
     * 输入：nums = [9], target = 3
     * 输出：0
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //todo 1.背包
        for (int i = 1; i <= target; i++) {
            //todo 2.物品
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
