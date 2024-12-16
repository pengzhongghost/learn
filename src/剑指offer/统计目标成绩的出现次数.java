package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 统计目标成绩的出现次数 {

    /**
     * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
     */

    public int countTarget(int[] scores, int target) {
        if(scores.length == 0) {
            return 0;
        }
        int left = 0, right = scores.length - 1;
        while(left<right ){
            int mid = (left +right) >> 1;
            if(target<=scores[mid]) {
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        int res = 0;
        while(left < scores.length && target == scores[left] ) {
            res++;
            left++;
        }
        return res;
    }

}
