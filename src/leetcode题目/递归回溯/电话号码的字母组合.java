package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    /**
     * 电话号码的字母组合
     *
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     *
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList();
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String str = phoneMap.get(digits.charAt(i));
            list.add(str);
        }
        List<String> result = new ArrayList<>();
        dfs(list, 0, new StringBuilder(), digits.length(), result);

        return result;
    }

    public static void dfs(List<String> list, int i, StringBuilder stringBuilder, int len, List<String> result) {
        if (stringBuilder.length() == len) {
            result.add(stringBuilder.toString());
            return;
        }
        String s = list.get(i);
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            stringBuilder.append(c);
            dfs(list, i + 1, stringBuilder, len, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
