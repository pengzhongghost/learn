package leetcode题目.逆波兰表达式;

import java.util.Stack;

public class 基本计算器II {
    /**
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     * 基本计算器II
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
     * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * <p>
     * 示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     * <p>
     * 示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     * <p>
     * 示例 3：
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     */
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
