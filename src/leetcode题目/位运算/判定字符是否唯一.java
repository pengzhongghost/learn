package leetcode题目.位运算;

public class 判定字符是否唯一 {
    /**
     * https://leetcode-cn.com/problems/is-unique-lcci/
     * 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: false
     * <p>
     * 示例 2：
     * 输入: s = "abc"
     * 输出: true
     */
    public static void main(String[] args) {
        String astr = "leetcode";
        astr = "abc";
        System.out.println(isUnique(astr));
    }

    public static boolean isUnique(String astr) {
        int t = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if ((t & (1 << c)) != 0) {
                return false;
            } else {
                //todo leetcode到第一个‘e’的时候二进制位此时为1
                t |= (1 << c);
            }
        }
        return true;
    }
}
