package leetcode题目.动态规划;

public class 解码方法 {
    /**
     * https://leetcode-cn.com/problems/decode-ways/
     * 解码方法
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
     * 例如，"11106" 可以映射为：
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * <p>
     * 示例 1：
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * <p>
     * 示例 2：
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     */
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        s = " " + s;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            //a : 代表「当前位置」单独形成
            int a = s.charAt(i) - '0';
            //b : 代表「当前位置」与「前一位置」共同形成
            int b = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (a > 0 && a < 10) {
                dp[i] = dp[i - 1];
            }
            if (b > 9 && b < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
