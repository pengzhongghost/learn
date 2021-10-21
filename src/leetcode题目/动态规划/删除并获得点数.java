package leetcode题目.动态规划;

public class 删除并获得点数 {
    /**
     * 给你一个整数数组nums，你可以对它进行一些操作。
     * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,2]
     * 输出：6
     * 解释：
     * 删除 4 获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        nums = new int[]{2, 2, 3, 3, 3, 4};
        nums = new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6};
        nums = new int[]{1, 1, 1};
        int count = deleteAndEarn(nums);
        System.out.println(count);
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        //构造一个新的数组all,下标表示nums中出现的数，数组里面代表此数字出现的次数
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item]++;
        }
        if (all.length == 2) {
            return all[1];
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        //动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }
}
