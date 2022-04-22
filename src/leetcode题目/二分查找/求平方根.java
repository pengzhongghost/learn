package leetcode题目.二分查找;

public class 求平方根 {
    /**
     * https://leetcode-cn.com/problems/jJ0w9p/
     * 求平方根
     * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
     * 正数的平方根有两个，只输出其中的正数平方根。
     * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     * 输入: x = 4
     * 输出: 2
     *
     * 示例 2:
     * 输入: x = 8
     * 输出: 2
     * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
     */
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int mySqrt02(int x) {
        return (int) Math.sqrt(x);
    }
}
