package leetcode题目.排序;

import java.util.Arrays;

public class 最接近的三数之和 {
    /**
     * 给定一个包括n 个整数的数组nums和 一个目标值target。
     * 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     */
    public static void main(String[] args) {
        //-4,-1,1,2
        int[] nums = {-1, 2, 1, -4};
        //nums = new int[]{1, 1, -1, -1, 3};
        //-3,0,1,2
        nums = new int[]{0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) {
            throw new RuntimeException("数组为空");
        }
        Arrays.sort(nums);
        int length = nums.length;
        int minResult = Integer.MAX_VALUE;
        int minTemp = Integer.MAX_VALUE;
        for (int first = 0; first < length; first++) {
            //如果和前面一个数相等，则跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third;
            for (int second = first + 1; second < length; second++) {
                third = length - 1;
                //如果和前面一个数相通，则跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third) {
                    int abs = Math.abs(nums[first] + nums[second] + nums[third] - target);
                    if (minTemp > abs) {
                        minTemp = abs;
                        minResult = nums[first] + nums[second] + nums[third];
                    }
                    third--;
                }
            }
        }
        return minResult;
    }

}
