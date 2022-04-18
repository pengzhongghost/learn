package leetcode题目.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {
    /**
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/
     * 和为 K 的子数组
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //nums = new int[]{1, 1, 1};
        //nums = new int[]{1, 2, 1, 2, 1};
        nums = new int[]{3, 4, 7, 2, -3, 1, 4, 2, 1};
        int count = subarraySum(nums, 7);
        System.out.println(count);
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (Integer num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
