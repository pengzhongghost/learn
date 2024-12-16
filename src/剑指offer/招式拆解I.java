package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 招式拆解I {

    /**
     * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     */

    public int dismantlingAction(String arr) {
        int fast = 0, slow = 0, maxLen = 0;
        Set<Character> set = new HashSet();
        while(fast < arr.length()) {
            char c = arr.charAt(fast);
            while(set.contains(c)) {
                set.remove(arr.charAt(slow++));
            }
            set.add(c);
            maxLen = Math.max(maxLen, fast - slow + 1);
            fast++;
        }
        maxLen = Math.max(maxLen, fast - slow);
        return maxLen;
    }

}
