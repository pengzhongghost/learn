package leetcode题目.java基础;

import java.util.Arrays;

public class 判定是否互为字符重排 {
    /**
     * https://leetcode-cn.com/problems/check-permutation-lcci/
     * 判定是否互为字符重排
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <p>
     * 示例 1：
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * <p>
     * 示例 2：
     * 输入: s1 = "abc", s2 = "bad"
     */
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(CheckPermutation(s1, s2));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        char[] chars01 = s1.toCharArray();
        char[] chars02 = s2.toCharArray();
        Arrays.sort(chars01);
        Arrays.sort(chars02);
        return Arrays.equals(chars01, chars02);
    }
}
