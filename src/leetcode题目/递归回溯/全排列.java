package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    public static void dfs(int[] nums, List<Integer> temp, boolean[] isVisited, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            //此处一定要new一个list，因为temp是不断变化的
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去除重复的
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp.add(nums[i]);
                dfs(nums, temp, isVisited, res);
                temp.remove(temp.size() - 1);
                isVisited[i] = false;
            }
        }
    }


}
