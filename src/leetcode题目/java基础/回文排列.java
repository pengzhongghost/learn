package leetcode题目.java基础;

import java.util.HashSet;
import java.util.Set;

public class 回文排列 {
    /**
     * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
     * 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     * <p>
     * 示例1：
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     */
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
    }

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }
}
