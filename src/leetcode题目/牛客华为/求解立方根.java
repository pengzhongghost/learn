package leetcode题目.牛客华为;

import java.util.Scanner;

public class 求解立方根 {

    //https://www.nowcoder.com/practice/caf35ae421194a1090c22fe223357dca?tpId=37&tqId=21330&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D3%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        double target = sc.nextDouble();
        double result;
        if (target > 0) {
            result = midSearch(0, target, target);
        } else if (target < 0) {
            result = midSearch(target, 0, target);
        } else {
            result = 0;
        }
        System.out.println(String.format("%.1f", result));
    }

    public static double midSearch(double left, double right, double target) {
        while (left < right) {
            double mid = (left + right) / 2;
            double data = target - mid * mid * mid;
            if (data > 0.0001) {
                left = mid;
            } else if (data < -0.0001) {
                right = mid;
            } else {
                break;
            }
        }
        return left;
    }

}
