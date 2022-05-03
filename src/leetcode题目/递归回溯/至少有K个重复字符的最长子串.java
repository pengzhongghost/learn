package leetcode题目.递归回溯;

public class 至少有K个重复字符的最长子串 {
    /**
     * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
     * 至少有K个重复字符的最长子串
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
     * <p>
     * 示例 1：
     * 输入：s = "aaabb", k = 3
     * 输出：3
     * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * <p>
     * 示例 2：
     * 输入：s = "ababbc", k = 2
     * 输出：5
     * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     */
    public static void main(String[] args) {
        String s = "aaabb";
        s = "ababbc";
        int k = 3;
        k = 2;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        int[] ant = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ant[s.charAt(i) - 'a']++;
        }
        //s = "ababbc" 剔除掉c
        String split = "";
        for (int i = 0; i < ant.length; i++) {
            if (ant[i] > 0 && ant[i] < k) {
                split = (char) (i + 'a') + "";
                break;
            }
        }
        //直接返回ababb.length()
        if ("".equals(split)) {
            return s.length();
        }
        int res = 0;
        //s = "ababb"
        String[] strs = s.split(split);
        for (String next : strs) {
            res = Math.max(res, longestSubstring(next, k));
        }
        return res;
    }
}
