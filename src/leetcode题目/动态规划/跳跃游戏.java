package leetcode题目.动态规划;

public class 跳跃游戏 {
    /**
     * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                //下标加上数即为能跳跃到到距离
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            //贪心算法，每次都跳的最远，只有最远都时候才跳
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

}
