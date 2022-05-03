package leetcode题目.位运算;

public class 两整数之和 {
    /**
     * https://leetcode-cn.com/problems/sum-of-two-integers/
     * 两整数之和
     * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
     * <p>
     * 示例 1：
     * 输入：a = 1, b = 2
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：a = 2, b = 3
     * 输出：5
     */
    public static void main(String[] args) {
        System.out.println(getSum(2,3));
    }

    //10^11=01
    //10&11=10   10<<1 100 都是1则进1
    public static int getSum(int a, int b) {
        if (a == 0 || b == 0) {
            return a ^ b;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
