package leetcode题目.排序;

import java.util.Arrays;

public class 最大数 {
    /**
     * https://leetcode-cn.com/problems/largest-number/
     * 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * <p>
     * 示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     */
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        nums = new int[]{0, 0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nums[i];
        }
        //todo 降序排序
        Arrays.sort(numbers, (a, b) -> {
            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            return (str2 + str1).compareTo(str1 + str2);
        });
        if (numbers[0] == 0) return "0";
        StringBuilder res = new StringBuilder();
        for (Integer num : numbers) {
            res.append(num);
        }
        return res.toString();
    }
}
