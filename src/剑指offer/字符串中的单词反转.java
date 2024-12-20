package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/18
 */
public class 字符串中的单词反转 {

    /**
     * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/description/
     */
    public String reverseMessage(String message) {
        StringBuilder sb = new StringBuilder();
        int i = message.length() - 1, j = i;
        while(i >= 0) {
            while(i >= 0 && message.charAt(i) != ' ') {
                i--;
            }
            sb.append(message.substring(i + 1, j + 1)).append(" ");
            while(i >= 0 && message.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

}
