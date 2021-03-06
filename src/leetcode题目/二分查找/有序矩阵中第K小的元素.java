package leetcode题目.二分查找;

public class 有序矩阵中第K小的元素 {
    /**
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
     * 有序矩阵中第K小的元素
     * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * 输出：13
     * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            //todo 如果<=mid的数大于等于k,则移动right指针
            if (check(matrix, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k) {
        int num = 0;
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            //todo 从左下角开始比较记录<=mid的数
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
