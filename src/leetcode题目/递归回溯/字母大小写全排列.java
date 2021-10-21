package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {

    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * <p>
     * 示例：
     * 输入：S = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * 输入：S = "3z4"
     * 输出：["3z4", "3Z4"]
     * <p>
     * 输入：S = "12345"
     * 输出：["12345"]
     */
    public static void main(String[] args) {
        List<String> res = letterCasePermutation("a1b2");
        System.out.println(res);
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), 0, res);
        return res;
    }

    public static void dfs(char[] chars, int index, List<String> res) {
        res.add(new String(chars));
        for (int i = index; i < chars.length; i++) {
            char aChar = chars[i];
            //如果不是数字
            if (!Character.isDigit(aChar)) {
                chars[i] = (char) (aChar - 'a' >= 0 ? aChar - 32 : aChar + 32);
                dfs(chars, i + 1, res);
                chars[i] = aChar;
            }
        }
    }
}
