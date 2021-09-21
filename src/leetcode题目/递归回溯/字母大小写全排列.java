package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {

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
