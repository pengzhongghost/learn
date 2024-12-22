package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {

    /**
     * https://leetcode.cn/problems/Ygoe9J/description/
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
     * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
     * <p>
     * 示例1：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * 示例2：
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * <p>
     * 示例 3：
     * 输入: candidates = [2], target = 1
     * 输出: []
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        List<List<Integer>> result = combinationSum02(nums, 8);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum02(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs02(nums, 0, target, result, new ArrayList<>());
        return result;
    }

    public static void dfs02(int[] nums, int index, int target, List<List<Integer>> result, List<Integer> res) {
        if (target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                res.add(nums[i]);
                dfs02(nums, i, target - nums[i], result, res);
                res.remove(res.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public static void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> res) {
        if (index == candidates.length) {
            return;
        }
        if (0 == target) {
            result.add(new ArrayList<>(res));
            return;
        }
        dfs(candidates, target, index + 1, result, res);
        if (target - candidates[index] >= 0) {
            res.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, result, res);
            res.remove(res.size() - 1);
        }

    }

}
