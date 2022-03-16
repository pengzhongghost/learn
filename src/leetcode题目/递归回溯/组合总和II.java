package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {

    /**
     * 组合总和 II
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。
     * <p>
     * 示例1:
     * 输入: candidates =[10,1,2,7,6,1,5], target =8,
     * 1 1 2 5 6 7 10
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
