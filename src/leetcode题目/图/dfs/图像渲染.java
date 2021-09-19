package leetcode题目.图.dfs;

import java.util.Arrays;

public class 图像渲染 {
    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     * <p>
     * 给你一个坐标(sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值newColor，让你重新上色这幅图像。
     * <p>
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
     * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
     * 重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析:
     * 在图像的正中间，(坐标(sr,sc)=(1,1)),
     * 在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，
     * 因为它不是在上下左右四个方向上与初始点相连的像素点。
     * <p>
     * 最后返回经过上色渲染后的图像。
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        arr = new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] res = floodFill(arr, 0, 0, 2);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    private final static int[] row = {1, 0, 0, -1};
    private final static int[] col = {0, 1, -1, 0};


    //深度优先遍历
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //首先记录当前点的颜色，之后需要改颜色
        int cur = image[sr][sc];
        int rowLen = image.length;
        int colLen = image[0].length;
        if (cur != newColor) {
            floodFill(image, sr, sc, cur, newColor);
        }
        return image;
    }

    //简单方法
    private static void floodFill(int[][] image, int sr, int sc, int cur, int newColor) {
        if (image[sr][sc] == cur) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                if (sr + row[i] >= 0 && sr + row[i] < image.length
                        && sc + col[i] >= 0 && sc + col[i] < image[0].length) {
                    floodFill(image, sr + row[i], sc + col[i], cur, newColor);
                }
            }
        }
    }

    //较多if判断
    private static void floodFill(int[][] image, int sr, int sc, int cur, int newColor, int rowLen, int colLen) {
        if (image[sr][sc] == cur) {
            image[sr][sc] = newColor;
            if (sr - 1 >= 0 && image[sr - 1][sc] == cur) {
                floodFill(image, sr - 1, sc, cur, newColor, rowLen, colLen);
            }
            if (sc + 1 < colLen && image[sr][sc + 1] == cur) {
                floodFill(image, sr, sc + 1, cur, newColor, rowLen, colLen);
            }
            if (sr + 1 < rowLen && image[sr + 1][sc] == cur) {
                floodFill(image, sr + 1, sc, cur, newColor, rowLen, colLen);
            }
            if (sc - 1 >= 0 && image[sr][sc - 1] == cur) {
                floodFill(image, sr, sc - 1, cur, newColor, rowLen, colLen);
            }
        }
    }

}
