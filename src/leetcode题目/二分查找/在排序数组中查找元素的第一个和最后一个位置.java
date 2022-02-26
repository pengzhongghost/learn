package leetcode题目.二分查找;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    /**
     *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 
     * 示例2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        //先找到第一个=target的下标
        int l = midSearch(nums, target);
        //再找出最后一个的下标
        int r = midSearch(nums, target + 1) - 1;
        if (l < nums.length &&nums[l] == target && r >= l) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }
    public static int midSearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                //target>num[mid]的时候让l一直往右边靠
                l = mid + 1;
            }
        }
        return l;
    }


}
