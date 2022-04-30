package leetcode题目.位运算;

public class 整数反转 {
    /**
     * 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * <p>
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     * <p>
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     */
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        long t = 0;
        while (x != 0) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        return (int) t == t ? (int) t : 0;
    }
}
