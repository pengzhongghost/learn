package leetcode题目.java基础;

import javafx.util.Pair;

import java.util.*;

public class 前K个高频元素 {
    /**
     * https://leetcode-cn.com/problems/top-k-frequent-elements/
     * 前 K 个高频元素
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * <p>
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * <p>
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        //nums = new int[]{1, 2};
        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //todo 找到最大次数
        int maxTime = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxTime = Math.max(entry.getValue(), maxTime);
        }
        int[] res = new int[k];
        //todo 找出所有数据
        while (k > 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxTime) {
                    res[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTime--;
        }
        return res;
    }

    //粗暴排序版
    public static int[] topKFrequent02(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        list.sort(Comparator.comparing(Pair::getValue));
        int[] res = new int[k];
        int temp = 0;
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            res[temp++] = list.get(i).getKey();
        }
        return res;
    }
}
