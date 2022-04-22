package leetcode题目.动态规划;

public class 翻转字符 {
    /**
     * https://leetcode-cn.com/problems/cyJERH/
     * 翻转字符
     * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，
     * 那么该字符串是 单调递增 的。我们给出一个由字符 '0' 和 '1' 组成的字符串 s，
     * 我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。返回使 s 单调递增 的最小翻转次数。
     * <p>
     * 示例 1：
     * 输入：s = "00110"
     * 输出：1
     * 解释：我们翻转最后一位得到 00111.
     * <p>
     * 示例 2：
     * 输入：s = "010110"
     * 输出：2
     * 解释：我们翻转得到 011111，或者是 000111。
     * <p>
     * 示例 3：
     * 输入：s = "00011000"
     * 输出：2
     * 解释：我们翻转得到 00000000。
     */
    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00011000"));
    }

    public static int minFlipsMonoIncr(String s) {
        int one = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res = Math.min(one, res + 1);
            } else {
                one++;
            }
        }
        return res;
    }
}
