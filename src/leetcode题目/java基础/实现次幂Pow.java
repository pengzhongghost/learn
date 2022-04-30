package leetcode题目.java基础;

public class 实现次幂Pow {
    /**
     * https://leetcode-cn.com/problems/powx-n/
     * Pow(x, n)
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
     * <p>
     * 示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * <p>
     * 示例 2：
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * <p>
     * 示例 3：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     */
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        double res = 1;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}
