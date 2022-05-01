package leetcode题目.java基础;

public class 阶乘后的零 {
    /**
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
     * 阶乘后的零
     * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
     * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
     * <p>
     * 示例 1：
     * 输入：n = 3
     * 输出：0
     * 解释：3! = 6 ，不含尾随 0
     * <p>
     * 示例 2：
     * 输入：n = 5
     * 输出：1
     */
    public static void main(String[] args) {
        System.out.println(trailingZeroes(130));
    }

    /**
     * 实际上就是计算1-n之中有多少个5的因数。以130为例：
     * 第一次除以5时得到26，表明存在26个包含 [一] 个因数5的数；
     * 第二次除以5得到5，表明存在5个包含 [二] 个因数5的数(这些数字的一个因数5已经在第一次运算的时候统计了)；
     * 第三次除以5得到1，表明存在1个包含 [三] 个因数5的数(这些数字的两个因数5已经在前两次运算的时候统计了)；
     * 得到从1-n中所有5的因数的个数
     */
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
