package leetcode题目.排序;

import java.util.Arrays;

public class 把数组排成最小的数 {
    /**
     * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
     * 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * 示例 1:
     * 输入: [10,2]
     * 输出: "102"
     *
     * 示例 2:
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            result.append(str[i]);
        }
        return result.toString();
    }
}
