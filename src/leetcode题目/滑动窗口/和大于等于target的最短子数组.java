package leetcode题目.滑动窗口;

public class 和大于等于target的最短子数组 {
    /**
     * https://leetcode-cn.com/problems/2VG8Kg/
     * 和大于等于 target 的最短子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * 示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     *
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        nums = new int[]{1, 4, 4};
        int target = 7;
        target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }

    //todo 滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int fast = 0, slow = 0, sum = 0, result = Integer.MAX_VALUE;
        while (fast < nums.length) {
            sum += nums[fast];
            while (sum >= target) {
                result = Math.min(result, fast - slow + 1);
                sum -= nums[slow++];
            }
            fast++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
