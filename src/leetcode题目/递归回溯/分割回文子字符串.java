package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 分割回文子字符串 {
    /**
     * https://leetcode-cn.com/problems/M99OJA/
     * 分割回文子字符串
     * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * 示例 1：
     * 输入：s = "google"
     * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
     *
     * 示例 2：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     */
    public static void main(String[] args) {
        String[][] partition = partition("google");
        for (String[] strings : partition) {
            System.out.println(Arrays.toString(strings));
        }
    }

    public static String[][] partition(String s) {
        List<List<String>> temp = new ArrayList<>();
        dfs(s, 0, temp, new ArrayList<>());
        String[][] res = new String[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = new String[temp.get(i).size()];
            for (int j = 0; j < temp.get(i).size(); j++) {
                res[i][j] = temp.get(i).get(j);
            }
        }
        return res;
    }

    public static void dfs(String s, int i, List<List<String>> result, List<String> res) {
        if (i == s.length()) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                res.add(s.substring(i, j + 1));
                dfs(s, j + 1, result, res);
                res.remove(res.size() - 1);
            }
        }
    }

    //todo 中心扩散法判断是否是回文字符串
    public static boolean isPalindrome(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        if (j - i < 3) {
            return true;
        }
        return isPalindrome(s, i + 1, j - 1);
    }
}
