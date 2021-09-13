package leetcode题目.双指针;

import java.util.Arrays;

public class 旋转数组 {
    /**
     * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
     * <p>
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        //nums = new int[]{1, 2};
        rotate02(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    //反转数组
    public static void rotate02(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //通过取模移位到一个新的数组中
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[(i + k) % length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, length);
    }

}
