package leetcode题目.java基础;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    /**
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
     * 找到所有数组中消失的数字
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     * <p>
     * 示例 1：
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     * <p>
     * 示例 2：
     * 输入：nums = [1,1]
     * 输出：[2]
     */
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] ant = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ant[nums[i]]++;
        }
        for (int i = 1; i < ant.length; i++) {
            if (ant[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
