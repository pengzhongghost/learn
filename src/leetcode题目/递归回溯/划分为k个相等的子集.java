package leetcode题目.递归回溯;

import java.util.Arrays;

public class 划分为k个相等的子集 {

    /**
     * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/?envType=problem-list-v2&envId=backtracking
     */
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 2));
    }

    static boolean result = false;

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        dfs(nums, 0, sum / k, 0, 0, new boolean[nums.length]);
        return result;
    }

    private static void dfs(int[] nums, int index, int total, int temp, int count, boolean[] isVisited) {
        if (4 == count) {
            result = true;
            return;
        }
        if (temp == total) {
            dfs(nums, 0, total, 0, count + 1, isVisited);
        }
        if (temp > total) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (isVisited[i] || (i > 0 && !isVisited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            dfs(nums, i + 1, total, temp + nums[i], count, isVisited);
            isVisited[i] = false;
        }
    }

}
