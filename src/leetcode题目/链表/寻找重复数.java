package leetcode题目.链表;

import java.util.HashSet;

public class 寻找重复数 {
    /**
     * https://leetcode-cn.com/problems/find-the-duplicate-number/
     * 寻找重复数
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     * <p>
     * 示例 1：
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //todo 采用链表  0->1->3->2->4
    //     4后面又是2是个循环链表
    //      快慢指针第一次相遇的地方为4
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int first = 0, second = fast;
        while (first != second) {
            first = nums[first];
            second = nums[second];
        }
        return first;
    }
    //hashset
    public static int findDuplicate02(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}
