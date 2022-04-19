package leetcode题目.逆波兰表达式;

public class 后缀表达式 {
    /**
     * https://leetcode-cn.com/problems/8Zf90G/
     * 后缀表达式
     * 根据 逆波兰表示法，求该后缀表达式的计算结果。
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     * 说明：
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * <p>
     * 示例 1：
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     */
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length + 1) / 2];
        int t = -1;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    t--;
                    stack[t] += stack[t + 1];
                    break;
                case "-":
                    t--;
                    stack[t] -= stack[t + 1];
                    break;
                case "*":
                    t--;
                    stack[t] *= stack[t + 1];
                    break;
                case "/":
                    t--;
                    stack[t] /= stack[t + 1];
                    break;
                default:
                    t++;
                    stack[t] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }

}
