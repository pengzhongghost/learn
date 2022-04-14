package leetcode题目.java基础;

import java.util.Arrays;

public class 打印从1到最大的n位数 {
    /**
     * 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(3)));
    }

    public static int[] printNumbers(int n) {
        int t = (int) Math.pow(10, n);
        int[] res = new int[t - 1];
        for (int i = 0; i < t - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
