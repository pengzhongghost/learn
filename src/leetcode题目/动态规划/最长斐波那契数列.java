package leetcode题目.动态规划;

import java.util.HashMap;
import java.util.Map;

public class 最长斐波那契数列 {
    /**
     * https://leetcode-cn.com/problems/Q91FMA/
     * 最长斐波那契数列
     * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
     * n >= 3
     * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
     * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
     * （回想一下，子序列是从原序列  arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
     * 例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
     *
     * 示例 1：
     * 输入: arr = [1,2,3,4,5,6,7,8]
     * 输出: 5
     * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
     *
     * 示例 2：
     * 输入: arr = [1,3,7,11,12,14,18]
     * 输出: 3
     * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        int[][] dp = new int[arr.length][arr.length];
        //map记录每个值的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                //dp[i][j]记录的从i到j到长度，dp[j][idx]记录从j到idx的长度
                int num = arr[i] + arr[j];
                int idx = map.getOrDefault(num, -1);
                if (idx != -1 && dp[j][idx] == 0) {
                    if (dp[i][j] == 0) dp[i][j] = 2;
                    dp[j][idx] = dp[i][j] + 1;
                    res = Math.max(res, dp[j][idx]);
                }
            }
        }
        return res;
    }
}
