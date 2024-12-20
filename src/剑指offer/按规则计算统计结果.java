package 剑指offer;

import java.util.Arrays;

/**
 * @author pengzhong
 * @since 2024/12/19
 */
public class 按规则计算统计结果 {

    /**
     * https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/description/
     */

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        int[] res = constructArr(a);
        System.out.println(Arrays.toString(res));
    }

    public static int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0, p = 1; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }
        for (int i = a.length - 1, p = 1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }
        return ans;
    }

}
