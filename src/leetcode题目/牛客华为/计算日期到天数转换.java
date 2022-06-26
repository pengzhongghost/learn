package leetcode题目.牛客华为;

import java.util.Calendar;
import java.util.Scanner;

public class 计算日期到天数转换 {

    /**
     * 输入描述：
     * 输入一行，每行空格分割，分别是年，月，日
     * <p>
     * 输出描述：
     * 输出是这一年的第几天
     * <p>
     * 示例1
     * 输入：
     * 2012 12 31
     * 复制
     * 输出：
     * 366
     * 复制
     * <p>
     * 示例2
     * 输入：
     * 1982 3 4
     * 复制
     * 输出：
     * 63
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt() - 1;
        int d = sc.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, m, d);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }

}
