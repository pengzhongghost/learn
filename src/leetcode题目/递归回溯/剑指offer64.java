package leetcode题目.递归回溯;

public class 剑指offer64 {
    /**
     * https://leetcode-cn.com/problems/qiu-12n-lcof/
     * 求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * <p>
     * 示例 1：
     * 输入: n = 3
     * 输出: 6
     * <p>
     * 示例 2：
     * 输入: n = 9
     * 输出: 45
     */
    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int n) {

        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
