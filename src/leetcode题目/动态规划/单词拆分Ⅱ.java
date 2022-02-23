package leetcode题目.动态规划;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词拆分Ⅱ {

    /**
     * 给定一个字符串 s 和一个字符串字典wordDict，在字符串s中增加空格来构建一个句子，
     * 使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * <p>
     * 示例 1：
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * 输出:["cats and dog","cat sand dog"]
     * <p>
     * 示例 2：
     * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * 解释: 注意你可以重复使用字典中的单词。
     */
    public static void main(String[] args) {
        String test = "pineapplepenapple";
        String[] wordDict = new String[]{
                "apple", "pen", "applepen", "pine", "pineapple"
        };
        单词拆分Ⅱ solution = new 单词拆分Ⅱ();
        List<String> res = solution.wordBreak(test, Arrays.asList(wordDict));
        System.out.println(res);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(s, 0, wordDict, list, res);
        return list;
    }

    private void dfs(String s, int index, List<String> wordDict, List<String> list, List<String> res) {
        if (index == s.length()) {
            list.add(StringUtils.join(res, " "));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (wordDict.contains(substring)) {
                res.add(substring);
                dfs(s, i + 1, wordDict, list, res);
                res.remove(substring);
            }
        }
    }

}
