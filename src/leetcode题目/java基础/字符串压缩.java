package leetcode题目.java基础;

public class 字符串压缩 {
    /**
     * https://leetcode-cn.com/problems/compress-string-lcci/
     * 字符串压缩
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
     * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
     * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * <p>
     * 示例1:
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 示例2:
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     */
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }

    public static String compressString(String S) {
        if (null == S || "".equals(S)) {
            return S;
        }
        StringBuilder result = new StringBuilder();
        char temp = S.charAt(0);
        int num = 1;
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == temp) {
                num++;
            } else {
                result.append(temp).append(num);
                num = 1;
                temp = c;
            }
        }
        result.append(temp).append(num);
        return result.toString().length() >= S.length() ? S : result.toString();
    }
}
