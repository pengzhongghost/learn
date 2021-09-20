package leetcode题目.图.bfs;

import java.util.Arrays;

public class 矩阵1离0的距离 {
    /**
     * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，
     * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     * <p>
     * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
     * 输出：[[0,0,0],[0,1,0],[1,2,1]]
     */
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        mat = new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };
        mat = updateMatrix(mat);
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    //integer的最大数+1为负数
                    res[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (res[i][j] > 0) {
                    if (i - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                    }
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动
        //此处反过来遍历是为了防止第一个数附近的数可能还是初始化的integer.max/2
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (res[i][j] > 0) {
                    if (i + 1 < m) {
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                    }
                }
            }
        }
        return res;
    }
}
