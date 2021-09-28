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

    /**
     * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
     * 示例 1：
     * 输入：[1,-2,3,-2]
     * 输出：3
     * 解释：从子数组 [3] 得到最大和 3
     * <p>
     * 示例 2：
     * 输入：[5,-3,5]
     * 输出：10
     * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
     * <p>
     * 示例 3：
     * 输入：[3,-1,2,-1]
     * 输出：4
     * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
     */
    //1：最大数组和在中间，和平时一样解法 2：最大数组和是跨越头尾，回头了，
    // 第二种，从两边出发往中间靠拢必须都是最大，那就说明中间段就是最小，找最小不就行了，
    public static int maxSum(int[] nums) {
        int maxSum = nums[0], pre = maxSum, sum = maxSum, min = 0;
        for (int i = 1; i < nums.length; i++) {
            //次数记录sum
            sum += nums[i];
            //pre是负数则去掉前面的数，以0代替
            pre = nums[i] + Math.max(pre, 0);
            maxSum = Math.max(maxSum, pre);
        }
        pre = nums[0];
        //此处获取到中间的最小值
        for (int i = 1; i < nums.length - 1; i++) {
            pre = nums[i] + Math.min(0, pre);
            min = Math.min(pre, min);
        }
        //sum减去中间的最小值
        return Math.max(sum - min, maxSum);
    }

}
