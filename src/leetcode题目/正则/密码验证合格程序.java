package leetcode题目.正则;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 密码验证合格程序 {

    /**
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
     * 数据范围：输入的字符串长度满足 1≤n≤100
     * <p>
     * 输入描述：
     * 一组字符串。
     * 输出描述：
     * 如果符合要求输出：OK，否则输出NG
     * <p>
     * 示例1
     * 输入：
     * 021Abc9000
     * 021Abc9Abc1
     * 021ABC9000
     * 021$bc9000
     * 复制
     * 输出：
     * OK
     * NG
     * NG
     * OK
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() > 8 && checkDigitAndLetter(line) && !isRepeat(line, 0, 3)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean checkDigitAndLetter(String line) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Z]");
        if (pattern.matcher(line).find()) {
            count++;
        }
        pattern = Pattern.compile("[a-z]");
        if (pattern.matcher(line).find()) {
            count++;
        }
        pattern = Pattern.compile("[0-9]");
        if (pattern.matcher(line).find()) {
            count++;
        }
        //^此符号是非这些数据,除了这些的其他字符
        pattern = Pattern.compile("[^a-zA-Z0-9]");
        if (pattern.matcher(line).find()) {
            count++;
        }
        return count >= 3;
    }

    public static boolean isRepeat(String line, int i, int j) {
        if (j >= line.length()) {
            return false;
        }
        if (line.substring(j).contains(line.substring(i, j))) {
            return true;
        }
        return isRepeat(line, i + 1, j + 1);
    }

}
