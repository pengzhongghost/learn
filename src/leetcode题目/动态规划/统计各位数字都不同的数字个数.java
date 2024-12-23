package leetcode题目.动态规划;

/**
 * @author pengzhong
 * @since 2024/12/23
 */
public class 统计各位数字都不同的数字个数 {

    /**
     * https://leetcode.cn/problems/count-numbers-with-unique-digits/description/?envType=problem-list-v2&envId=backtracking
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (0 == n) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }

}
