package leetcode题目.动态规划;

public class 一个小组的最大实力 {

    /**
     * https://leetcode.cn/problems/maximum-strength-of-a-group/description/?envType=problem-list-v2&envId=backtracking
     */

    public long maxStrength(int[] nums) {
        long max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++ ) {
            long temp = max;
            max = Math.max(Math.max(max, nums[i]), Math.max(max * nums[i], min * nums[i]));
            min = Math.min(Math.min(min, nums[i]), Math.min(temp * nums[i], min * nums[i]));
        }
        return max;
    }

}
