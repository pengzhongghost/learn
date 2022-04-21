package leetcode题目.排序;

import java.util.HashMap;
import java.util.Map;

public class 值和下标之差都在给定的范围内 {
    /**
     * https://leetcode-cn.com/problems/7WqeDu/
     *值和下标之差都在给定的范围内
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
     * 同时又满足 abs(i - j) <= k 。
     * 如果存在则返回 true，不存在返回 false。
     *
     * 示例 1：
     * 输入：nums = [1,2,3,1], k = 3, t = 0
     * 输出：true
     *
     * 示例 2：
     * 输入：nums = [1,0,1,1], k = 1, t = 2
     * 输出：true
     *
     * 示例 3：
     * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出：false
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        nums=new int[]{1,2};

        //System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(nums, 0,1));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        long gap =(long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            //todo 将数据放在桶中  0-t一个桶，t到t+t一个桶
            long id = getId(nums[i], gap);
            //todo 在同一个桶中的直接返回true
            if (map.containsKey(id)) {
                return true;
            }
            //todo 不在同一个桶中则比较相减之后的值的大小
            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < gap) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < gap) {
                return true;
            }
            //此处写在上面是为了只有两个元素的时候能在下面删除不符合k的情况
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], gap));
            }
        }
        return false;
    }

    //todo 考虑到边界问题 最大的int，最小的int
    public static long getId(long num, long gap) {
        if (num>=0){
            return num / gap;
        }
        return (num+1) / gap-1;
    }
}
