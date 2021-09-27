package leetcode题目.动态规划;

public class 乘积最大子数组 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组
     * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释:子数组 [2,3] 有最大乘积 6。
     * <p>
     * 示例 2:
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        nums = new int[]{-2, 0, -1};
        nums = new int[]{-3, -1, -1};
        nums = new int[]{-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    //存在负数，那么会导致最大的变最小的，最小的变最大的
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            //每次数据<0的时候则让max=min去进行计算，用min来保存最小的负数
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
