package leetcode题目.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分 {

    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
     * 判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * <p>
     * 示例 1：
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     * <p>
     * 示例 2：
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     * 注意你可以重复使用字典中的单词。
     * <p>
     * 示例 3：
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        s = "applepenapple";
//        wordDict.add("apple");
//        wordDict.add("pen");
//        s = "aaaaaaa";
//        wordDict.add("aaaa");
//        wordDict.add("aaa");
        s = "catsandog";
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean flag = wordBreak(s, wordDict);
        System.out.println(flag);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    //记录前一个字母,catsandog,cats,and,sand为单词，但是o不能计为true
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
