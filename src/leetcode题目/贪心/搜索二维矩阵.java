package leetcode题目.贪心;

public class 搜索二维矩阵 {
    /**
     * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 输入：matrix = {
     * {1, 4, 7, 11, 15},
     * {2, 5, 8, 12, 19},
     * {3, 6, 9, 16, 22},
     * {10, 13, 14, 17, 24},
     * {18, 21, 23, 26, 30}
     * },
     * target = 5
     * 输出：true
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    //todo 贪心算法 从右上角开始
    public static boolean searchMatrix(int[][] matrix, int target) {
        //todo i要++，j要--才行
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {
                i++;
            }
        }
        return false;
    }
}
