package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    /**
     * https://leetcode-cn.com/problems/subsets/
     * 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //nums = new int[]{0};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> res) {
        //if (res.size() >= 0) {
        result.add(new ArrayList<>(res));
        //}
        for (int i = index; i < nums.length; i++) {
            res.add(nums[i]);
            dfs(nums, i + 1, result, res);
            res.remove(res.size() - 1);
        }
    }
}
