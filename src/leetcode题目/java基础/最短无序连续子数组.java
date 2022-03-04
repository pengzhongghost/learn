package leetcode题目.java基础;

public class 最短无序连续子数组 {
    /**
     * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
     * 最短无序连续子数组
     * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 请你找出符合题意的 最短 子数组，并输出它的长度。
     * <p>
     * 示例 1：
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     */
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        nums = new int[]{1, 2, 3, 4};
        nums = new int[]{1, 3, 2, 2, 2};
        nums = new int[]{2, 3, 3, 2, 4};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
