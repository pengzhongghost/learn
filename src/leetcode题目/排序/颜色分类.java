package leetcode题目.排序;

import java.util.Arrays;

public class 颜色分类 {
    /**
     * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库的sort函数的情况下解决这个问题。
     * 示例 1：
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * <p>
     * 示例 2：
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int insertValue, beforeIndex;
        for (int i = 1; i < nums.length; i++) {
            insertValue = nums[i];
            beforeIndex = i;
            while (beforeIndex > 0 && insertValue < nums[beforeIndex - 1]) {
                nums[beforeIndex] = nums[beforeIndex - 1];
                beforeIndex--;
            }
            if (beforeIndex != i) {
                nums[beforeIndex] = insertValue;
            }
        }
    }
}
