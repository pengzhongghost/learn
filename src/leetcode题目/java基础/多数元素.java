package leetcode题目.java基础;

import java.util.Arrays;

public class 多数元素 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。
     * 多数元素是指在数组中出现次数 大于n/2的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 示例 1：
     * 输入：[3,2,3]
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
