package leetcode题目.牛客华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 参数解析 {

    /**
     * https://www.nowcoder.com/practice/668603dc307e4ef4bb07bcd0615ea677?tpId=37&tqId=21297&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> result = new ArrayList();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '\"') {
                flag = !flag;
                continue;
            }
            if (c == ' ' && !flag) {
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString());
        System.out.println(result.size());
        for (String str : result) {
            System.out.println(str);
        }
    }

}
