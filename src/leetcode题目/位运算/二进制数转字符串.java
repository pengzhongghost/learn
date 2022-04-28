package leetcode题目.位运算;

public class 二进制数转字符串 {
    /**
     * 二进制数转字符串
     * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
     * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
     *
     * 示例1:
     * 输入：0.625
     * 输出："0.101"
     *
     * 示例2:
     * 输入：0.1
     * 输出："ERROR"
     * 提示：0.1无法被二进制准确表示
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(printBin(0.625));
    }

    public static String printBin(double num) {
        StringBuilder result = new StringBuilder("0.");
        while (num != 0 && result.length() <= 32) {
            num *= 2;
            if (num >= 1) {
                num -= 1;
                result.append("1");
            } else {
                result.append("0");
            }
        }
        return result.length() > 32 ? "ERROR" : result.toString();
    }
}
