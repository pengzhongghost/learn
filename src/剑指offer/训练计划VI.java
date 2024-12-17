package 剑指offer;

public class 训练计划VI {

    /**
     * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/description/
     */
    public int trainingPlan(int[] actions) {
        int[] cnt = new int[32];
        for(int action :actions) {
            for(int i = 0; i < 32; i++) {
                cnt[i] += action&1;
                action >>= 1;
            }
        }
        int res = 0;
        for(int i = 31; i >=0; i--) {
            res <<= 1;
            res |= cnt[i] % 3;
        }
        return res;
    }

}
