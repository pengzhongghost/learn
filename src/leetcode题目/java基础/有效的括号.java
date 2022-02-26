package leetcode题目.java基础;

import java.util.Stack;

public class 有效的括号 {
    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     *
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     *
     * 示例 5：
     * 输入：s = "{[]}"
     * 输出：true
     */

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid01(String s) {
        String s1 = "()";
        String s2 = "[]";
        String s3 = "{}";
        while (true) {
            if (s.contains(s1)) {
                s = s.replace(s1, "");
            } else if (s.contains(s2)) {
                s = s.replace(s2, "");
            } else if (s.contains(s3)) {
                s = s.replace(s3, "");
            } else {
                break;
            }
        }
        return s.equals("");
    }
}
