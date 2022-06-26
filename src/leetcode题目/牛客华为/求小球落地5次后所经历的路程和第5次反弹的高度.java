package leetcode题目.牛客华为;

import java.util.Scanner;

public class 求小球落地5次后所经历的路程和第5次反弹的高度 {

    /**
     * https://www.nowcoder.com/practice/2f6f9339d151410583459847ecc98446?tpId=37&tqId=21261&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = sc.nextInt(), lastHigh = sum;
        for (int i = 0; i < 5; i++) {
            lastHigh = lastHigh / 2;
            sum += lastHigh * 2;
        }
        System.out.println(sum - lastHigh * 2);
        System.out.println(lastHigh);
    }

}
