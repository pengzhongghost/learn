package leetcode题目.java基础;

import java.util.Arrays;

public class 下一个序列 {
    /**
     * 下一个排列
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
     * 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * <p>
     * 示例 2：
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * <p>
     * 示例 3：
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     */
    //TODO nums = [1,2,7,4,3,1],
    //     第一步: 倒序遍历数组, 找出第一组: 前一个数比后一个数小的两个数, 即[2, 7]
    //     2所处的这个位置就是需要找出比它稍微大的数的位置;
    //     我们从[7,4,3,1]中找出比2大的数中的最小值, 也就是3, 找到后跟2交换即可;; 当然了, 如果没找到的话, 直接跳到第5步, 直接升序排列输出.
    //     目前nums=[1,3,7,4,2,1], 不用我说你们也看出来还不算下一个排列
    //     对3后面的数, 升序排列, 即最终结果: nums = [1,3,1,2,4,7]
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nums = new int[]{3, 2, 1};
        //nums = new int[] {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
