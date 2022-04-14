package leetcode题目.java基础;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    /**
     * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
     * 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     * <p>
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(arr)));
    }

    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (leftNum % 2 == 0 && rightNum % 2 != 0) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            } else if (leftNum % 2 != 0) {
                left++;
            } else {
                right--;
            }
        }
        return nums;
    }
}
