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

    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c != 0) {
            int m = i >= 0 ? a.charAt(i--) - '0' : 0;
            int n = j >= 0 ? b.charAt(j--) - '0' : 0;
            c = m + n + c;
            result.append(c % 2);
            c /= 2;
        }
        return result.reverse().toString();
    }
}
