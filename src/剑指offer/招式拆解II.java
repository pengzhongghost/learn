package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 招式拆解II {

    /**
     * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/description/
     */

    public char dismantlingAction(String arr) {
        int[] chars = new int[26];
        for(int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            if(arr.indexOf(c) == arr.lastIndexOf(c)) {
                return c;
            }
        }
        return ' ';
    }

}
