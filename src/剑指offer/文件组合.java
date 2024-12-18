package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengzhong
 * @since 2024/12/18
 */
public class 文件组合 {

    /**
     * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
     */

    public static void main(String[] args) {
        int[][] res = fileCombination(12);
        System.out.println(Arrays.toString(res));
    }

    public static int[][] fileCombination(int target) {
        List<int[]> res = new ArrayList();
        for (int i = 1, j = 2; i < j; ) {
            int sum = (i + j) * (j - i + 1) / 2;
            if (target == sum) {
                int[] arr = new int[j - i + 1];
                int k = 0;
                for (int m = i; m <= j; m++) {
                    arr[k++] = m;
                }
                res.add(arr);
                i++;
            } else if (target > sum) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
