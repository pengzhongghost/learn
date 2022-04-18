package leetcode题目.位运算;

public class 单词长度的最大乘积 {
    /**
     * https://leetcode-cn.com/problems/aseY1I/
     * 单词长度的最大乘积
     * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
     * 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
     * <p>
     * 示例 1:
     * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
     * <p>
     * 示例 2:
     * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * <p>
     * 示例 3:
     * 输入: words = ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     */
    public static void main(String[] args) {
        String[] words = {"ab", "cd", "aef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                masks[i] |= 1 << word.charAt(j) - 'a';
            }
        }
        int maxResult = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxResult = Math.max(maxResult, words[i].length() * words[j].length());
                }
            }
        }
        return maxResult;
    }
}
