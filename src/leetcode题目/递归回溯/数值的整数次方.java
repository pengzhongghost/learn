package leetcode题目.递归回溯;

public class 数值的整数次方 {
    /**
     * 数值的整数次方
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
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
        System.out.println(myPow(3, 3));
    }

    public static double myPow(double x, int n) {
        return n >= 0 ? dfs(x, n) : 1 / dfs(x, -n);
    }

    public static double dfs(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = dfs(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
