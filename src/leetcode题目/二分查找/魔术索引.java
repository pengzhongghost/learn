package leetcode题目.二分查找;

public class 魔术索引 {
    /**
     * 魔术索引
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，
     * 编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * <p>
     * 示例1:
     * 输入：nums = [0, 2, 3, 4, 5]
     * 输出：0
     * 说明: 0下标的元素为0
     * <p>
     * 示例2:
     * 输入：nums = [1, 1, 1]
     * 输出：1
     */
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 5};
        System.out.println(findMagicIndex(nums));
    }

    public static int findMagicIndex(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static int dfs(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        int leftNum = dfs(nums, left, mid - 1);
        if (leftNum != -1) {
            return leftNum;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return dfs(nums, mid + 1, right);
    }

}
