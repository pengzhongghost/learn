package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class 文物朝代判断 {

    /**
     * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
     */

    public boolean checkDynasty(int[] places) {
        Set<Integer> set = new HashSet();
        int max = -1, min = 14;
        for(int place: places) {
            if(0 == place) {
                continue;
            }
            if(set.contains(place)) {
                return false;
            }
            max = Math.max(max, place);
            min = Math.min(min, place);
            set.add(place);
        }
        return max - min < 5;
    }

}
