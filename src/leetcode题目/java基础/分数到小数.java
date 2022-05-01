package leetcode题目.java基础;

import java.util.HashMap;
import java.util.Map;

public class 分数到小数 {
    /**
     * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
     * 分数到小数
     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
     * 如果小数部分为循环小数，则将循环的部分括在括号内。
     * 如果存在多个答案，只需返回 任意一个 。
     * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
     * <p>
     * 示例 1：
     * 输入：numerator = 1, denominator = 2
     * 输出："0.5"
     * <p>
     * 示例 2：
     * 输入：numerator = 2, denominator = 1
     * 输出："2"
     * <p>
     * 示例 3：
     * 输入：numerator = 4, denominator = 333
     * 输出："0.(012)"
     */
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4, 333));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        //负数的情况
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) sb.append("-");
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        //可以整除的情况
        if (a % b == 0) return sb.toString();
        //小数
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        //计算小数
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) return sb.toString();
        return sb.insert(map.get(a).intValue(), '(').append(")").toString();
    }
}
