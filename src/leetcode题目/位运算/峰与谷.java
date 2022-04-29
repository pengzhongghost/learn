package leetcode题目.位运算;

import java.util.Arrays;

public class 峰与谷 {
    /**
     * 峰与谷
     * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，
     * “谷”是小于或等于相邻整数的元素。例如，
     * 在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。
     * 现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
     * <p>
     * 示例:
     * 输入: [5, 3, 1, 2, 3]
     * 输出: [5, 1, 3, 2, 3]
     */
    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 2, 3};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //todo 0 1 2 3 4
            //这个位置是峰
            if (i % 2 == 0) {
                if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            } else {
                //这个位置是谷
                if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
            }
        }
    }
    public static void swap(int[] num, int i, int j) {
        num[i] ^= num[j];
        num[j] ^= num[i];
        num[i] ^= num[j];
    }
}
