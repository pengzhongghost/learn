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

    /**
     * dfs版本
     */
    public int crackNumber02(int ciphertext) {
        return dfs(ciphertext + "", 0);
    }

    private int dfs(String ciphertext, int index) {
        if(index == ciphertext.length()) {
            return 1;
        }
        if(index > ciphertext.length()) {
            return 0;
        }
        char c = ciphertext.charAt(index);
        if('1' == c) {
            int res = dfs(ciphertext, index + 1);
            res += dfs(ciphertext, index + 2);
            return res;
        }
        if('2' == c) {
            int res = dfs(ciphertext, index + 1);
            if(index + 2 <= ciphertext.length()
                    && ciphertext.charAt(index + 1) >= '0'
                    && ciphertext.charAt(index + 1) <= '5') {
                res += dfs(ciphertext, index + 2);
            }
            return res;
        }
        return dfs(ciphertext, index + 1);
    }

    /**
     * 改造成动态规划版本
     */
    public int crackNumber03(int ciphertext) {
        String word = ciphertext + "";
        int[] dp = new int[word.length() + 1];
        dp[word.length()] = 1;
        for (int i = word.length() - 1 ; i >= 0; i--) {
            char c = word.charAt(i);
            if ('1' == c) {
                int ans = dp[i + 1];
                if (i < word.length() - 1) {
                    ans += dp[i + 2];
                }
                dp[i] = ans;
            } else if ('2' == c) {
                int ans = dp[i + 1];
                if (i < word.length() - 1 && word.charAt(i + 1) >= '0'
                        && word.charAt(i + 1) <= '5') {
                    ans += dp[i + 2];
                }
                dp[i] = ans;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }


}
