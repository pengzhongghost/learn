package 剑指offer;

public class 查找总价格为目标值的两个商品 {

    /**
     * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/description/
     */

    public int[] twoSum(int[] price, int target) {
        int left = 0, right = price.length - 1;
        while (left < right) {
            int sum = price[left] + price[right];
            if (target == sum) {
                return new int[]{price[left], price[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

}
