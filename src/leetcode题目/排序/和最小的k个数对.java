package leetcode题目.排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 和最小的k个数对 {
    /**
     * https://leetcode-cn.com/problems/qn8gGX/
     * 和最小的k个数对
     * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
     * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * 输出: [1,2],[1,4],[1,6]
     * 解释: 返回序列中的前 3 对数：
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * <p>
     * 示例 2:
     * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * 输出: [1,1],[1,1]
     * 解释: 返回序列中的前 2 对数：
     * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * <p>
     * 示例 3:
     * 输入: nums1 = [1,2], nums2 = [3], k = 3
     * 输出: [1,3],[2,3]
     * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println(kSmallestPairs(nums1, nums2, 3));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        for (int value : nums1) {
            for (int i : nums2) {
                res.add(Arrays.asList(value, i));
            }
        }
        res.sort(Comparator.comparingInt(list0 -> (list0.get(0) + list0.get(1))));
        while (res.size() > k) {
            res.remove(res.size() - 1);
        }
        return res;
    }

}
