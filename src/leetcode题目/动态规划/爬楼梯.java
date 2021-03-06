package leetcode题目.动态规划;

public class 爬楼梯 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static void main(String[] args) {
        int i = climbStairs02(10);
        System.out.println(i);
    }

    //每次爬2，3级台阶
    public static int climbStairs02(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    //斐波那契数列
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
