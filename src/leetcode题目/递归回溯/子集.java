package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
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
