package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> list = combinationSum2(nums, 8);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //todo 首先需要排序
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public static void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> res) {
        if (target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                //todo 排序之后才能去重
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                res.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, result, res);
                res.remove(res.size() - 1);
            }
        }
    }

}
