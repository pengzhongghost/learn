package 剑指offer;

public class 位1的个数 {

    /**
     * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/description/
     */
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }

}
