package 动态规划;

public class 启蒙2 {

    /**
     * 递归的方式
     */
    public static int number(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if ('1' == str[i]) {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if ('2' == str[i]) {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }

    /**
     * 动态规划
     */
    public static int dpWay2(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ('0' == str[i]) {
                dp[i] = 0;
            } else if ('1' == str[i]) {
                dp[i] = dp[i + 1];
                if (i + 1 < str.length) {
                    dp[i] += dp[i + 2];
                }
            } else if ('2' == str[i]) {
                dp[i] = dp[i + 1];
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }


}
