package leetcode题目.位运算;

import java.util.Arrays;

public class 前n个数字二进制中1的个数 {
    /**
     * https://leetcode-cn.com/problems/w3tCBm/
     * 前 n 个数字二进制中 1 的个数
     * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
     * <p>
     * 示例 1:
     * 输入: n = 2
     * 输出: [0,1,1]
     * 解释:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * <p>
     * 示例 2:
     * 输入: n = 5
     * 输出: [0,1,1,2,1,2]
     * 解释:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
