package leetcode题目.java基础;

import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
    /**
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     * 剑指 Offer 03. 数组中重复的数字
     * 找出数组中重复的数字。
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                return nums[i];
            } else {
                result.add(nums[i]);
            }
        }
        return -1;
    }
}
