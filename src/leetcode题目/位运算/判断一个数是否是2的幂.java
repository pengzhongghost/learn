package leetcode题目.位运算;

public class 判断一个数是否是2的幂 {
    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；
     * 否则，返回 false 。
     * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
     * <p>
     * 提示：
     * -231 <= n <= 231 - 1
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }

    //如果n是2的次幂，则n的二进制都是0
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    //最大是2的30次方
    public static boolean isPowerOfTwo01(int n) {
        int maxNum = 1 << 30;
        return n > 0 && maxNum % n == 0;
    }
}
