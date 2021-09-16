package leetcode题目.双指针;

public class 字符串的排列 {
    /**
     * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     * 示例 1：
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * <p>
     * 提示：
     * 1 <= s1.length, s2.length <= 104
     * s1 和 s2 仅包含小写字母
     */
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
//        s1 = "abc";
//        s2 = "bbbca";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        //s1长度大于s2
        if (n > m) {
            return false;
        }
        //只有小写字母
        int[] cnt = new int[26];
        //将s1中的字母赋值入数组 -1
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            //s2中的字符如果>0，则移动左指针,=0说明此字符是s1中的字符
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            //当s2的字符连起来==s1的字符数，则返回真
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
