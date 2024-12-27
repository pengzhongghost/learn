package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/26
 */
public class 将字符串拆分为递减的连续值 {

    /**
     * https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        boolean result = splitString("200100");
        System.out.println(result);
    }

    public static boolean splitString(String s) {
        int i = 0, n = s.length();
        // 去除s前导0，排除掉全0的情况
        while (i < n && s.charAt(i) == '0') {
            i++;
        }
        if (i == n) return false; // 全是前导0

        long pre = 0; // 第一个子串数值（最多20位数字）
        for (; i < n - 1; i++) { // 枚举第一个子串，长度为1 ~ n - 1（至少划分2个子串）
            pre = pre * 10 + (s.charAt(i) - '0');
            if (dfs(pre, s, i, n)) return true; // 能划分到最后，说明可以划分
        }
        return false; // 没有划分成功就是划分失败
    }

    public static boolean dfs(long preNum, String s, int pos, int n) {
        if (pos == n - 1) return true; // 划分到最后一个位置，划分成功
        if (preNum == 0) { // 前面子串数值为0，后边若全为0则成功划分（后边0全归到上一个子串），否则失败
            for (int i = pos + 1; i < n; i++) {
                if (s.charAt(i) != '0') return false;
            }
            return true;
        }
        long cur = 0; // 当前子串数值
        for (int i = pos + 1; i < n; i++) { // 从pos + 1开始划分下一个子串
            cur = cur * 10 + (s.charAt(i) - '0');
            if (cur == preNum - 1) {
                return dfs(cur, s, i, n); // 满足cur == pre - 1，划分下一个子串
            } else if (cur >= preNum) {
                return false; // cur >= pre时，再往后划分只会大于等于pre，划分失败
            }
        }
        return false; // 没有划分成功就是划分失败
    }

}
