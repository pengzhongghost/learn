package leetcode题目.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 数字0和1个数相同的子数组 {
    /**
     * https://leetcode-cn.com/problems/A1NYOS/
     * 0 和 1 个数相同的子数组
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * <p>
     * 示例 1:
     * 输入: nums = [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
     * <p>
     * 示例 2:
     * 输入: nums = [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre)) {
                res = Math.max(res, i - map.get(pre));
            } else {
                map.put(pre, i);
            }
        }
        return res;
    }
}
