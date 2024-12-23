package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/16
 */
public class 解密数字 {



    /**
     * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     *
     * 示例 1:
     * 输入: ciphertext = 216612
     * 输出: 6
     * 解释: 216612 解密后有 6 种不同的形式，分别是 "cbggbc"，
     * "vggbc"，"vggm"，"cbggm"，"cqgbc" 和 "cqgm"
     */

    public int crackNumber(int ciphertext) {
        if(0 == ciphertext || 1 == ciphertext){
            return 1;
        }
        String str = "" + ciphertext;
        int[] dp = new int[str.length() + 1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i < dp.length; i++) {
            String tempStr = str.substring(i - 2, i);
            if( tempStr.compareTo("10") >= 0 && tempStr.compareTo("25") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[str.length()];
    }

}
