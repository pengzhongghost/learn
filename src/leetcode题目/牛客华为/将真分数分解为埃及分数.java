package leetcode题目.牛客华为;

import java.util.Scanner;

public class 将真分数分解为埃及分数 {

    /**
     * https://www.nowcoder.com/practice/e0480b2c6aa24bfba0935ffcca3ccb7b?tpId=37&tqId=21305&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] sa = scanner.nextLine().split("/");
            int f1 = Integer.parseInt(sa[0]);
            int f2 = Integer.parseInt(sa[1]);
            for (int i = 0; i < f1; i++) {
                if (i + 1 < f1) {
                    System.out.print("1/" + f2 + "+");
                } else {
                    System.out.println("1/" + f2);
                }
            }
        }
    }

}
