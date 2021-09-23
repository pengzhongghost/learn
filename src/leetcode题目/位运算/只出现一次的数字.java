package leetcode题目.位运算;

public class 只出现一次的数字 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int num = singleNumber(nums);
        System.out.println(num);
    }

    //按位异或，一个为0，一个为1，出现过两次的最终会为0
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
