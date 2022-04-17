package leetcode题目.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列 {
    /**
     * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
     * 和为s的连续正数序列
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     * 示例 1：
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * <p>
     * 示例 2：
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     */
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(15);
        for (int[] res : continuousSequence) {
            System.out.println(Arrays.toString(res));
        }
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1, j = 2; i < j; ) {
            int sum = (i + j) * (j - i + 1) / 2;
            if (target == sum) {
                int[] ant = new int[j - i + 1];
                int t = 0;
                for (int k = i; k <= j; k++) {
                    ant[t++] = k;
                }
                res.add(ant);
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
