package leetcode题目.动态规划;

public class 硬币 {
    /**
     * https://leetcode-cn.com/problems/coin-lcci/
     * 硬币
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
     * (结果可能会很大，你需要将结果模上1000000007)
     * <p>
     * 示例1:
     * 输入: n = 5
     * 输出：2
     * 解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * <p>
     * 示例2:
     * 输入: n = 10
     * 输出：4
     * 解释: 有四种方式可以凑成总金额:
     * 10=10
     * 10=5+5
     * 10=5+1+1+1+1+1
     * 10=1+1+1+1+1+1+1+1+1+1
     */
    public static void main(String[] args) {
        //System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
    }

    public static int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
