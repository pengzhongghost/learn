package leetcode题目.java基础;

public class 三的幂 {
    /**
     * https://leetcode-cn.com/problems/power-of-three/
     * 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     * <p>
     * 示例 1：
     * 输入：n = 27
     * 输出：true
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 1 || n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
