package leetcode题目.牛客华为;

import java.util.Scanner;

public class 统计每个月兔子的总数 {

    /**
     * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
     * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
     * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
     * 数据范围：输入满足 1≤n≤31
     * <p>
     * 输入描述：
     * 输入一个int型整数表示第n个月
     * 输出描述：
     * 输出对应的兔子总数
     * <p>
     * 示例1
     * 输入：
     * 3
     * 复制
     * 输出：
     * 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTotalCount(sc.nextInt()));
    }

    public static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }

}
