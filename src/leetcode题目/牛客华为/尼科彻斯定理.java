package leetcode题目.牛客华为;

import java.util.Scanner;

public class 尼科彻斯定理 {

    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     * 例如：
     * <p>
     * 1^3=1
     * 2^3=3+5
     * 3^3=7+9+11
     * 4^3=13+15+17+19
     * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
     * 数据范围：1≤m≤100
     * 进阶：时间复杂度：O(m) ，空间复杂度：O(1)
     * <p>
     * 输入描述：
     * 输入一个int整数
     * 输出描述：
     * 输出分解后的string
     * <p>
     * 示例1
     * 输入：
     * 6
     * 复制
     * 输出：
     * 31+33+35+37+39+41
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int start = m * (m - 1) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                sb.append(start);
            } else {
                sb.append(start).append("+");
            }
            start += 2;
        }
        System.out.println(sb.toString());
    }

}
