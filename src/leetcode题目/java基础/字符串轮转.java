package leetcode题目.java基础;

public class 字符串轮转 {
    /**
     * https://leetcode-cn.com/problems/string-rotation-lcci/
     * 字符串轮转
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
     * （比如，waterbottle是erbottlewat旋转后的字符串）。
     * <p>
     * 示例1:
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"
     * 输出：True
     * <p>
     * 示例2:
     * 输入：s1 = "aa", s2 = "aba"
     * 输出：False
     */
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s2 += s2;
        return s2.contains(s1);
    }
}
