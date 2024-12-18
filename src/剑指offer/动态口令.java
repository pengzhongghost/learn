package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/18
 */
public class 动态口令 {

    /**
     * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/description/
     */
    public String dynamicPassword(String password, int target) {
        return password.substring(target, password.length()) + password.substring(0, target);
    }

}
