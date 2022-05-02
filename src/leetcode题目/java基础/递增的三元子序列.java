package leetcode题目.java基础;

public class 递增的三元子序列 {
    /**
     * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
     * 递增的三元子序列
     * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，
     * 返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,4,5]
     * 输出：true
     * 解释：任何 i < j < k 的三元组都满足题意
     * <p>
     * 示例 2：
     * 输入：nums = [5,4,3,2,1]
     * 输出：false
     * 解释：不存在满足题意的三元组
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
    }

    /**
     * a 始终记录最小元素，b 为某个子序列里第二大的数。
     * 接下来不断更新 a，同时保持 b 尽可能的小。
     * 如果下一个元素比 b 大，说明找到了三元组。
     */
    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
