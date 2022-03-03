package leetcode题目.位运算;

import java.util.Arrays;

public class 比特位计数 {
    /**
     * https://leetcode-cn.com/problems/counting-bits/
     * 比特位计数
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     * <p>
     * 示例 1：
     * 输入：n = 2
     * 输出：[0,1,1]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * <p>
     * 示例 2：
     * 输入：n = 5
     * 输出：[0,1,1,2,1,2]
     * 解释：
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public static int[] countBits02(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
