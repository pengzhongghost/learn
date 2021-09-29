package leetcode题目.动态规划;

public class 等差数列划分 {
    /**
     * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
     * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
     * 子数组 是数组中的一个连续序列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：3
     * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
     * <p>
     * 示例 2：
     * 输入：nums = [1]
     * 输出：0
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        nums = new int[]{1, 2, 3, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            /**
             * 三个等差数列：1个子数组
             * 四个等差数列: 1+2个子数组
             * 五个等差数列: 1+2+3个子数组
             */
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
