package leetcode题目.排序;

public class 寻找两个正序数组的中位数 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        num1 = new int[]{1, 3};
        num2 = new int[]{2};
        double result = findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            res[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[index++] = nums2[j++];
        }
        int length = res.length;
        if (length % 2 == 0) {
            int mid = length / 2;
            return (double) (res[mid] + res[mid - 1]) / (double) 2;
        } else {
            return res[length / 2];
        }
    }
}
