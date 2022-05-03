package leetcode题目.位运算;

public class 不用加减乘除做加法 {
    /**
     * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
     * 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     * <p>
     * 示例:
     * 输入: a = 1, b = 1
     * 输出: 2
     */
    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }

    public static int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a ^ b;
        }
        //10^11=01
        //10&11=10   10<<1 100 都是1则进1
        return add(a ^ b, (a & b) << 1);
    }

}
