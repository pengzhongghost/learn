package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列II {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nums = new int[]{1, 1, 2};
        nums = new int[]{2, 2, 1, 1};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, result, new ArrayList<>(), isVisited);
        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> res, boolean[] isVisited) {
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //1 1 2 2 去除的是第二个1和前面一个1相同所以要去除
            if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])) continue;
            res.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, result, res, isVisited);
            res.remove(res.size() - 1);
            isVisited[i] = false;
        }
    }
}
