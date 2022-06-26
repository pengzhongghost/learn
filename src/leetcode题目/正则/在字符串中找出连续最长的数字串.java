package leetcode题目.正则;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 在字符串中找出连续最长的数字串 {

    /**
     * https://www.nowcoder.com/practice/2c81f88ecd5a4cc395b5308a99afbbec?tpId=37&tqId=21315&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split("[^0-9]+");
            List<String> list = new ArrayList<>();
            int maxLen = 0;
            for (String s : split) {
                if (s.length() > maxLen) {
                    maxLen = s.length();
                    list.clear();
                    list.add(s);
                } else if (s.length() == maxLen) {
                    list.add(s);
                }
            }
            for (String s : list) {
                System.out.print(s);
            }
            System.out.println("," + maxLen);
        }
    }

}
