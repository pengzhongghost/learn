package leetcode题目.递归回溯;

public class 递归乘法 {
    /**
     * https://leetcode-cn.com/problems/recursive-mulitply-lcci/
     * 递归乘法
     * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     * <p>
     * 示例1:
     * 输入：A = 1, B = 10
     * 输出：10
     * <p>
     * 示例2:
     * 输入：A = 3, B = 4
     * 输出：12
     */
    public static void main(String[] args) {
        System.out.println(multiply(1, 10));
    }

    public static int multiply(int A, int B) {
        if (B == 0) return 0;
        return A + multiply(A, B - 1);
    }
}
