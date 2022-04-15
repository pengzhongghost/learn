package leetcode题目.java基础;

import java.util.LinkedHashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    /**
     * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
     * 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例 1:
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * <p>
     * 示例 2:
     * 输入：s = ""
     * 输出：' '
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static char firstUniqChar(String s) {
        int[] dp = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            dp[aChar - 'a']++;
        }
        for (char aChar : chars) {
            if (dp[aChar - 'a'] == 1) {
                return aChar;
            }
        }
        return ' ';
    }

    public static char firstUniqChar02(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
