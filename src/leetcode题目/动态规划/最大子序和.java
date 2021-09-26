package leetcode题目.动态规划;

public class 最大子序和 {
    /**
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     * <p>
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //nums = new int[]{-2, 1};
        nums = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
