package leetcode题目.螺旋矩阵;

import java.util.Arrays;

public class 螺旋矩阵II {
    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     * 螺旋矩阵II
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * 示例 1：
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     */
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, index = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[i][right] = index++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[bottom][i] = index++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[i][left] = index++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
