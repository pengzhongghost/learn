package leetcode题目.牛客华为;

import java.util.Scanner;

public class 进制转换 {

    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
     * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
     * 31
     *  −1
     * 输入描述：
     * 输入一个十六进制的数值字符串。
     * 输出描述：
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     *
     * 示例1
     * 输入：
     * 0xAA
     * 复制
     * 输出：
     * 170
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        System.out.println(Integer.parseInt(nextLine.substring(2),16));
    }

}
