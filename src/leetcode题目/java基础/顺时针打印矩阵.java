package leetcode题目.java基础;

import java.util.Arrays;

public class 顺时针打印矩阵 {
    /**
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        //matrix = new int[][] {
        //        {1, 2, 3, 4},
        //        {5, 6, 7, 8},
        //        {9, 10, 11, 12},
        //        {13, 14, 15, 16}
        //};
        int[] res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int right = matrix[0].length - 1, left = 0, bottom = matrix.length - 1, top = 0, index = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
