package leetcode题目.二分查找;

import java.util.Arrays;

public class 数组相对排序 {
    /**
     * https://leetcode-cn.com/problems/0H97ZC/
     * 数组相对排序
     * 给定两个数组，arr1 和 arr2，
     * arr2 中的元素各不相同arr2 中的每个元素都出现在 arr1 中对 arr1 中的元素进行排序，
     * 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * <p>
     * 示例：
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     */
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ant = new int[1001];
        for (int num : arr1) {
            ant[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            for (int i = 0; i < ant[num]; i++) {
                arr1[index++] = num;
            }
            ant[num] = 0;
        }
        for (int i = 0; i < ant.length; i++) {
            for (int j = 0; j < ant[i]; j++) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
