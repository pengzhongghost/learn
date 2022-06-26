package leetcode题目.牛客华为;

import java.util.Scanner;

public class 求最大连续bit数 {
    /**
     * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     * 数据范围：数据组数：500000\1≤n≤500000
     * 进阶：时间复杂度：O(logn) ，空间复杂度：O(1)
     * <p>
     * 输入描述：
     * 输入一个int类型数字
     * 输出描述：
     * 输出转成二进制之后连续1的个数
     * <p>
     * 示例1
     * 输入：
     * 200
     * 复制
     * 输出：
     * 2
     * 复制
     * 说明：
     * 200的二进制表示是11001000，最多有2个连续的1。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String binaryStr = Integer.toBinaryString(num);
        String[] split = binaryStr.split("0");
        int result = 0;
        for (String s : split) {
            result = Math.max(result, s.length());
        }
        System.out.println(result);
    }

}
