package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    /**
     * 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     */
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;
    }

    public static void dfs(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {// 左右括号都不剩余了，递归终止
            result.add(str);
            return;
        }
        if (left > 0) {// 如果左括号还剩余的话，可以拼接左括号
            dfs(str + "(", left - 1, right, result);
        }
        //之所以right要>left是为了生成有效的括号(),不能生成)(
        if (right > left) {// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(str + ")", left, right - 1, result);
        }
    }
    //TODO 之所以stringBuilder每次都要删掉最后一个,是因为stringbuilder只有一个对象
    //     string每拼接一次就生成一个对象
    public static void dfsStringBulder(StringBuilder str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {// 左右括号都不剩余了，递归终止
            result.add(str.toString());
            return;
        }
        if (left > 0) {// 如果左括号还剩余的话，可以拼接左括号
            dfsStringBulder(str.append("("), left - 1, right, result);
            str.deleteCharAt(str.length()-1);
        }
        //之所以right要>left是为了生成有效的括号(),不能生成)(
        if (right > left) {// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfsStringBulder(str.append(")"), left, right - 1, result);
            str.deleteCharAt(str.length()-1);
        }
    }
}
