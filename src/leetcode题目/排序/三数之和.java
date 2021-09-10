package leetcode题目.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    /**
     * 求出三数之和是0的数组
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        nums = new int[]{0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        for (int first = 0; first < nums.length; first++) {
            //如果这个数和之前的数相通则跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                //如果这个数和之前的数相通则跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //移动第三个指针
                while (second < third && (nums[third] + nums[second]) > target) {
                    third--;
                }
                //第二个指针和第三个指针重合，则break
                if (second == third) {
                    break;
                }
                //符合三个数相加=0
                if (nums[third] + nums[second] == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    result.add(res);
                }
            }
        }
        return result;
    }
}
