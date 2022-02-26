package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II {
    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,2]
     * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     * <p>
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        //nums = new int[]{0};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> res) {
        result.add(new ArrayList<>(res));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            res.add(nums[i]);
            dfs(nums, i + 1, result, res);
            res.remove(res.size() - 1);
        }
    }
}
