package leetcode题目.位运算;

public class 二进制加法 {
    /**
     * https://leetcode-cn.com/problems/JFETK5/
     * 二进制加法
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     * 示例 1:
     * 输入: a = "11", b = "10"
     * 输出: "101"
     *
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public static void main(String[] args) {
        System.out.println(addBinary("11","10"));
    }

    public static String addBinary(String a, String b) {
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
