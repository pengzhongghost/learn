package leetcode题目.二分查找;

public class 在排序数组中查找数字I {

    /**
     * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
     * 在排序数组中查找数字 I
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     */
    public static void main(String[] args) {
        int[] nums = {1};
        nums = new int[]{5, 7, 7, 8, 8, 10};
        nums = new int[]{2, 2};
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, mid, result = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        while (left < nums.length && nums[left++] == target) {
            result++;
        }
        return result;
    }

}
