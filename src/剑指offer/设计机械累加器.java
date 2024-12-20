package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/19
 */
public class 设计机械累加器 {

    /**
     * https://leetcode.cn/problems/qiu-12n-lcof/
     */

    public int mechanicalAccumulator(int target) {
        if(1 == target) {
            return target;
        }
        return target + mechanicalAccumulator(target - 1);
    }

}
