package leetcode题目.排序;

import java.util.Arrays;

public class 摆动排序II {
    /**
     * https://leetcode-cn.com/problems/wiggle-sort-ii/
     * 摆动排序II
     * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     * 你可以假设所有输入数组都可以得到满足题目要求的结果。
     * <p>
     * 示例 1：
     * 输入：nums = [1,5,1,1,6,4]
     * 输出：[1,6,1,5,1,4]
     * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
     * <p>
     * 示例 2：
     * 输入：nums = [1,3,2,2,3,1]
     * 输出：[2,3,1,3,1,2]
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        nums = new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int mid = (nums.length - 1) >> 1, right = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i += 2) {
            nums[i] = copy[mid--];
            nums[i + 1] = copy[right--];
        }
        if (copy.length % 2 == 1) {
            nums[nums.length - 1] = copy[mid];
        }
    }
}
