package leetcode题目.二分查找;

public class 搜索插入位置 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public static int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        } else if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int mid = (high + low) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid] && mid != 0 && target > nums[mid - 1]) {
            return mid;
        } else if (target < nums[mid]) {
            return search(nums, low, mid - 1, target);
        } else if (target > nums[mid] && target < nums[mid + 1]) {
            return mid + 1;
        } else if (target > nums[mid]) {
            return search(nums, mid + 1, high, target);
        }
        return -1;
    }
}
