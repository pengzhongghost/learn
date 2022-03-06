package leetcode题目.java基础;

public class 回文子串 {
    /**
     * 回文子串
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     * 示例 1：
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "aaa";
        int res = countSubstrings(s);
        System.out.println(res);
    }

    //todo 中心扩散法
    public static int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            //需要考虑到奇数偶数
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
                res++;
            }
        }
        return res;
    }
}
