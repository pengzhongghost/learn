package leetcode题目.递归回溯;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 字符串的排列 {
    /**
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
     * 剑指 Offer 38. 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     * 示例:
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(permutation("suvyls")));
    }

    //全排列的变种
    public static String[] permutation(String s) {
        //不能有重复元素,所以用set
        Set<String> res = new HashSet<>();
        dfs(s, res, "", new boolean[s.length()]);
        return res.toArray(new String[res.size()]);
    }

    public static void dfs(String s, Set<String> res, String str, boolean[] isVisited) {
        if (str.length() == s.length()) {
            res.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isVisited[i] || (i > 0 && !isVisited[i - 1] && s.charAt(i - 1) == s.charAt(i))) continue;
            isVisited[i] = true;
            dfs(s, res, str + s.charAt(i), isVisited);
            isVisited[i] = false;
        }
    }
}
