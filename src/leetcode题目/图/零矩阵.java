package leetcode题目.图;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 零矩阵 {
    /**
     * https://leetcode-cn.com/problems/zero-matrix-lcci/
     * 零矩阵
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * <p>
     * 示例 1：
     * 输入：
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出：
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    set.add(new int[]{i, j});
                }
            }
        }
        for (int[] ant : set) {
            int row = ant[0];
            int col = ant[1];
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
