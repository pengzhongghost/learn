package leetcode题目.java基础;

public class 最长公共前缀 {
    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * <p>
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(temp)) {
                if (temp.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                temp = temp.substring(0, temp.length() - 1);
            }
        }
        return temp;
    }
}
