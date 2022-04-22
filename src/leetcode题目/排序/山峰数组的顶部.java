package leetcode题目.排序;

public class 山峰数组的顶部 {
    /**
     * https://leetcode-cn.com/problems/B1IidL/
     * 山峰数组的顶部
     * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
     * arr.length >= 3
     * 存在 i（0 < i < arr.length - 1）使得：
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] <
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
     * <p>
     * 示例 1：
     * 输入：arr = [0,1,0]
     * 输出：1
     */
    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 25, 2, 8};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
            } else {
                return i - 1;
            }
        }
        return 0;
    }
}
