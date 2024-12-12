package 剑指offer;

public class 整数拆分 {

    /**
     * https://leetcode.cn/problems/integer-break/
     */
    public static void main(String[] args) {
        int res = integerBreak(5);
        System.out.println(res);
    }

    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

}
