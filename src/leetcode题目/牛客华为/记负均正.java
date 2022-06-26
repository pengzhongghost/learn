package leetcode题目.牛客华为;

import java.util.Scanner;

public class 记负均正 {
    /**
     * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
     * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
     * 数据范围： 1≤n ≤2000  ，输入的整数都满足 val∣≤1000
     * <p>
     * 输入描述：
     * 首先输入一个正整数n，
     * 然后输入n个整数。
     * 输出描述：
     * 输出负数的个数，和所有正整数的平均值。
     * <p>
     * 示例1
     * 输入：
     * 11
     * 1 2 3 4 5 6 7 8 9 0 -1
     * 复制
     * 输出：
     * 1 5.0
     * 复制
     * 示例2
     * 输入：
     * 3
     * 0 0 0
     * 复制
     * 输出：
     * 0 0.0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        int pcount = 0, ncount = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 0) {
                pcount++;
                sum += num;
            } else if (num < 0) {
                ncount++;
            }
        }
        if (pcount == 0) {
            System.out.println(ncount + " 0.0");
        } else {
            System.out.println(ncount + " " + String.format("%.1f", sum / pcount));
        }
    }

}
