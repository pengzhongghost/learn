package leetcode题目.正则;

import java.util.Scanner;

public class 字符串通配符 {

    /**
     *实现通配符
     *? 匹配一个字符  [0-9A-Za-z]{1}
     *匹配0个或以上的字符  [0-9A-Za-z]{0,}
     *（字符由英文字母和数字0-9组成，不区分大小写。下同）
     * https://www.nowcoder.com/practice/43072d50a6eb44d2a6c816a283b02036?tpId=37&tqId=21294&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String regx = scanner.nextLine();
            String string = scanner.nextLine();
            //做相应的替换
            regx = regx.replaceAll("\\?", "[0-9A-Za-z]{1}");
            regx = regx.replaceAll("\\*", "[0-9A-Za-z]{0,}");
            regx = regx.replaceAll("\\.", "\\\\.");
            boolean result = string.matches(regx);
            System.out.println(result);
        }
    }

}
