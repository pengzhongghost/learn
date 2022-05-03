package leetcode题目.java基础;

public class 字符串中的第一个唯一字符 {
    /**
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 字符串中的第一个唯一字符
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * <p>
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: 0
     * <p>
     * 示例 2:
     * 输入: s = "loveleetcode"
     * 输出: 2
     */
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] ant = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ant[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ant[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
