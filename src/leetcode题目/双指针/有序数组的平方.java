package leetcode题目.双指针;

import java.util.Arrays;

public class 有序数组的平方 {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，
     * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * 示例 1：
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     */
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] arr = sortedSquares02(nums);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 双指针
     * 先把平方之后大的放进去
     */
    public static int[] sortedSquares03(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int[] result = new int[nums.length];
        int pos = result.length - 1;
        while (low <= high) {
            if (nums[low] * nums[low] > nums[high] * nums[high]) {
                result[pos--] = nums[low] * nums[low++];
            } else if (nums[low] * nums[low] <= nums[high] * nums[high]) {
                result[pos--] = nums[high] * nums[high--];
            }
        }
        return result;
    }

    //类似归并排序双指针
    //找到<0的位置
    public static int[] sortedSquares02(int[] nums) {
        int temp = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                temp = i;
            }
        }
        int i = temp;
        int j = temp + 1;
        int[] result = new int[length];
        int tempIndex = 0;
        while (i >= 0 && j < length) {
            if (-nums[i] <= nums[j]) {
                result[tempIndex++] = nums[i] * nums[i--];
            } else {
                result[tempIndex++] = nums[j] * nums[j++];
            }
        }
        while (i >= 0) {
            result[tempIndex++] = nums[i] * nums[i--];
        }
        while (j < length) {
            result[tempIndex++] = nums[j] * nums[j++];
        }
        return result;
    }


    //快速排序(移位法)
    public static int[] sortedSquares01(int[] nums) {
        nums[0] = nums[0] * nums[0];
        int tempIndex;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            tempIndex = i - 1;
            temp = nums[i] * nums[i];
            while (tempIndex != -1 && temp < nums[tempIndex]) {
                nums[tempIndex + 1] = nums[tempIndex];
                tempIndex--;
            }
            //平方之后仍需要换成新的数
            nums[tempIndex + 1] = temp;
        }
        return nums;
    }


}
