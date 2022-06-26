package leetcode题目.牛客华为;

import java.util.Scanner;

public class 查找组成一个偶数最接近的两个素数 {

    /**
     * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
     * 本题目要求输出组成指定偶数的两个素数差值最小的素数对。
     * 数据范围：输入的数据满足 4≤n≤1000
     * 输入描述：
     * 输入一个大于2的偶数
     *
     * 输出描述：
     * 从小到大输出两个素数
     *
     * 示例1
     * 输入：
     * 20
     * 复制
     * 输出：
     * 7
     * 13
     * 复制
     * 示例2
     * 输入：
     * 4
     * 复制
     * 输出：
     * 2
     * 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n >> 1; i >= 1; i--) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println(i);
                System.out.println(n - i);
                break;
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
