package leetcode题目.动态规划;

import java.util.Arrays;

public class 每日温度 {
    /**
     * 每日温度
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * https://leetcode-cn.com/problems/daily-temperatures/
     */
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     * - res[i+1]=0，那么res[i]=0;
     * - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] dp = new int[temperatures.length];
        dp[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += dp[j]) {
                if (temperatures[i] < temperatures[j]) {
                    //后面第几天会升温
                    dp[i] = j - i;
                    break;
                } else if (dp[j] == 0) {
                    dp[i] = 0;
                    break;
                }
            }
        }
        return dp;
    }
}
