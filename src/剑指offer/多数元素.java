package 剑指offer;

public class 多数元素 {

    /**
     * https://leetcode.cn/problems/majority-element/description/
     */
    public int majorityElement(int[] nums) {
        int votes = 0, curNum = 0;
        for(int num: nums) {
            if(0 == votes) {
                curNum = num;
            }
            votes += curNum == num ? 1: -1;
        }
        return curNum;
    }

}
