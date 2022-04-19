package leetcode题目.排序;

import java.util.Arrays;

public class 有效的变位词 {
    /**
     * https://leetcode-cn.com/problems/dKk3P7/
     * 有效的变位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
     * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
     */
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return !s.equals(t) && Arrays.equals(sChars, tChars);
    }
}
