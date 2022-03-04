package leetcode题目.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    /**
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
     * 找到字符串中所有字母异位词
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * 示例 1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     */
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    //todo 滑动窗口
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int[] sAnt = new int[26];
        int[] pAnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++sAnt[s.charAt(i) - 'a'];
            ++pAnt[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sAnt, pAnt)) {
            res.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            --sAnt[s.charAt(i) - 'a'];
            ++sAnt[s.charAt(i + p.length()) - 'a'];
            if (Arrays.equals(sAnt, pAnt)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
