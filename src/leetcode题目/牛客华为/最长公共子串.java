package leetcode题目.牛客华为;

import java.util.Scanner;

public class 最长公共子串 {

    /**
     * https://www.nowcoder.com/practice/181a1a71c7574266ad07f9739f791506?tpId=37&tqId=21288&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line01 = sc.nextLine();
        String line02 = sc.nextLine();
        if (line01.length() < line02.length()) {
            System.out.println(getLongestStr(line01, line02));
        } else {
            System.out.println(getLongestStr(line02, line01));
        }

    }

    private static String getLongestStr(String str01, String str02) {
        if (str02.contains(str01)) {
            return str01;
        }
        int len = str01.length() - 1;
        for (int i = 0; i < str01.length(); i++) {
            if (len == 0) break;
            if (i + len <= str01.length()) {
                String substring = str01.substring(i, i + len);
                if (str02.contains(substring)) {
                    return substring;
                }
            } else {
                len--;
                i = -1;
            }
        }
        return "";
    }

}
