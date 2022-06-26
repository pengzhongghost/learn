package leetcode题目.牛客华为;

import java.util.Scanner;

public class 合法IP {

    /**
     * https://www.nowcoder.com/practice/995b8a548827494699dc38c3e2a54ee9?tpId=37&tqId=21313&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String[] split = ip.split("\\.");
        boolean flag = true;
        if (split.length == 4) {
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith("0") && split[i].length() > 1||split[i].startsWith("+")) {
                    flag = false;
                }
                try {
                    int num = Integer.parseInt(split[i]);
                    if (num < 0 || num > 255) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        System.out.println(flag ? "YES" : "NO");
    }

}
