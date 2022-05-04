package leetcode题目.java基础;

public class 字符串相乘 {
    /**
     * https://leetcode-cn.com/problems/multiply-strings/
     * 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * <p>
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * <p>
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     */
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
        //System.out.println(multiply("123456789", "987654321"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + a * b;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
