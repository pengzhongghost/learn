package 剑指offer;

import java.util.Arrays;

public class 螺旋遍历二维数组 {

    /**
     * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
     */

    public static void main(String[] args) {
        int[][] array =
                {{1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}};
        int[] res = spiralArray(array);
        System.out.println(Arrays.toString(res));
    }

    static int[] result;

    public static int[] spiralArray(int[][] array) {
        if(0 == array.length) {
            return new int[0];
        }
        result = new int[array.length * array[0].length];
        boolean[][] isVisited = new boolean[array.length][array[0].length];
        spiralArray(array, isVisited, 0, 0, 0, false);
        return result;
    }

    private static void spiralArray(int[][] array, boolean[][] isVisited, int i, int j, int index, boolean isToTop) {
        if (i < 0 || j < 0 || i >= array.length || j >= array[i].length || isVisited[i][j]) {
            return;
        }
        result[index] = array[i][j];
        isVisited[i][j] = true;
        if (isToTop) {
            spiralArray(array, isVisited, i - 1, j, index + 1, true);
            spiralArray(array, isVisited, i , j+ 1, index + 1, false);
            spiralArray(array, isVisited, i+ 1, j , index + 1, false);
            spiralArray(array, isVisited, i , j- 1, index + 1, false);
        } else {
            spiralArray(array, isVisited, i , j+ 1, index + 1, false);
            spiralArray(array, isVisited, i+ 1, j , index + 1, false);
            spiralArray(array, isVisited, i , j- 1, index + 1, false);
            spiralArray(array, isVisited, i - 1, j, index + 1, true);
        }
    }

}