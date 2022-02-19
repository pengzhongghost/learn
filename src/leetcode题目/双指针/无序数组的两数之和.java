package leetcode题目.双指针;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 无序数组的两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int parNum = target - nums[i];
            if (map.containsKey(parNum)) {
                return new int[]{i, map.get(parNum)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
