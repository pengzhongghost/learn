package 剑指offer;

public class 数值的整数次方 {

    /**
     * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/description/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return N < 0 ? 1 / quickMul(x, -N) : quickMul(x, N);
    }

    private static double quickMul(double x, long n) {
        if(n == 0) {
            return 1;
        }
        double y = quickMul(x, n >> 1);
        double res;
        if (n % 2 == 0) {
            res = y * y;
        } else {
            res = y * y * x;
        }
        return res;
    }


}
