package leetcode题目.双指针;

public class 反转字符串中的单词 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords02(str));
    }

    //直接使用java的api
    public static String reverseWords02(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = s.split(" ");
        for (String str : strs) {
            stringBuilder.append(str).reverse().append(" ");
        }
        return stringBuilder.toString().trim();
    }

    //双指针
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            while (chars[right] != ' ') {
                if (right == chars.length - 1) {
                    break;
                }
                right++;
            }
            if (right == chars.length - 1) {
                reverse(chars, left, right);
            } else {
                reverse(chars, left, right - 1);
            }
            left = right + 1;
            right++;
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int l, int r) {
        int left = l, right = r;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
