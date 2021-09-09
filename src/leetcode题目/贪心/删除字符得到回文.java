package leetcode题目.贪心;

public class 删除字符得到回文 {
    /**
     * 给定一个非空字符串 s，请判断如果 最多
     * 从字符串中删除一个字符能否得到一个回文字符串。
     * 提示:
     * 1 <= s.length <= 10 ^ 5
     * s 由小写英文字母组成
     * <p>
     * 示例 1:
     * 输入: s = "aba"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: s = "abca"
     * 输出: true
     * 解释: 可以删除 "c" 字符 或者 "b" 字符
     * <p>
     * 示例 3:
     * 输入: s = "abc"
     * 输出: false
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "adc";
        s = "cbbcc";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }

    public static boolean validPalindrome(String s) {
        //使用两个指针，一个指向字符串第一个，
        //一个指向字符串最后一个
        int l = 0;
        int r = s.length() - 1;
        int mid = (r + l) / 2;
        //当左指针到达中间字符即为true
        int[] idx = check(s, l, r);
        if (idx[0] > mid) {
            return true;
        }
        //如果左指针没有到达中间字符就让左指针加1跳过一个字符
        //或者让右指针减一跳过一个字符
        return check(s, idx[0] + 1, idx[1])[0] > mid
                || check(s, idx[0], idx[1] - 1)[0] >= mid;
    }

    //当字符相同的时候就移动双指针
    public static int[] check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            } else {
                l++;
                r--;
            }
        }
        return new int[]{l, r};
    }

}
