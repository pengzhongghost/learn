package leetcode题目.java基础;

public class 翻转单词顺序 {
    /**
     * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
     * 翻转单词顺序
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     * <p>
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * <p>
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * <p>
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */
    public static void main(String[] args) {
        //System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        int left = 0, right = split.length - 1;
        while (left < right) {
            String temp = split[left];
            split[left++] = split[right];
            split[right--] = temp;
        }
        StringBuilder result = new StringBuilder();
        for (String str : split) {
            if (str.equals("")) continue;
            result.append(str).append(" ");
        }
        return result.toString().trim();
    }
}
