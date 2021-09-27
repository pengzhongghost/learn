package leetcode题目.动态规划;

public class 乘积为正数的最长子数组长度 {

    /**
     * 给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
     * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
     * 请你返回乘积为正数的最长子数组长度。
     * <p>
     * 示例 1：
     * 输入：nums = [1,-2,-3,4]
     * <p>
     * 输出：4
     * 解释：数组本身乘积就是正数，值为 24 。
     * <p>
     * 示例 2：
     * 输入：nums = [0,1,-2,-3,-4]
     * 输出：3
     * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
     * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
     */
    public static void main(String[] args) {
        int[] nums = {1, -2, -3, 4};
        nums = new int[]{0, 1, -2, -3, -4};
        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        int length = nums.length;
        int positive = 0;
        int negative = 0;
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            //当一个数字是正数的时候，前面一个数如果是负数，则负数+1；前面是正数，负数+0。
            if (nums[i] > 0) {
                negative = negative > 0 ? negative + 1 : 0;
                positive = positive + 1;
            } else if (nums[i] < 0) {
                //当这个数是负数的时候，负数肯定是前一个正数+1，当前一个数是负数，则正数+1，否则为0
                int temp = positive;
                positive = negative > 0 ? negative + 1 : 0;
                negative = temp + 1;
            } else {
                //当这个数为0的时候
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }

    public static int getMaxLen01(int[] nums) {
        int length = nums.length;
        //通过两个数组让最长的长度在两个数组交替变换
        int[] positive = new int[length];
        int[] negative = new int[length];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength, positive[i]);
        }
        return maxLength;
    }

}
