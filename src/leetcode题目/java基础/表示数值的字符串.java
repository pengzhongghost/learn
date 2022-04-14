package leetcode题目.java基础;

public class 表示数值的字符串 {
    /**
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
     * 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     *
     * 数值（按顺序）可以分成以下几个部分：
     * 若干空格
     * 一个 小数 或者 整数
     * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     * 若干空格
     * 小数（按顺序）可以分成以下几个部分：
     * （可选）一个符号字符（'+' 或 '-'）
     * 下述格式之一：
     * 至少一位数字，后面跟着一个点 '.'
     * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 一个点 '.' ，后面跟着至少一位数字
     * 整数（按顺序）可以分成以下几个部分：
     * （可选）一个符号字符（'+' 或 '-'）
     * 至少一位数字
     * 部分数值列举如下：
     * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
     * 部分非数值列举如下：
     * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
     */
    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
    }

    public static boolean isNumber(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        s = s.trim();
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        char c = s.charAt(s.length() - 1);
        return c >= '0' && c <= '9' || c == '.';
    }
}
