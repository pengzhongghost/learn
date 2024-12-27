package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/27
 */
public class 根据模式串构造最小数字 {

    /**
     * https://leetcode.cn/problems/construct-smallest-number-from-di-string/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        String result = smallestNumber("DDDDDDDD");
        System.out.println(result);
    }

    static String result = "";

    public static String smallestNumber(String pattern) {
        boolean[] isVisited = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            isVisited[i] = true;
            dfs(pattern, 0, "" + i, isVisited);
            isVisited[i] = false;
        }
        return result;
    }

    private static void dfs(String pattern, int index, String temp, boolean[] isVisited) {
        if (index == pattern.length()) {
            if (!"".equals(result)) {
                if (temp.compareTo(result) < 0) {
                    result = temp;
                }
            } else {
                result = temp;
            }
            return;
        }
        char c = pattern.charAt(index);
        int preNum = temp.charAt(temp.length() - 1) - '0';
        for (int i = 1; i < 10; i++) {
            if (isVisited[i]) {
                continue;
            }
            if ('D' == c && preNum <= i) {
                break;
            }
            if ('I' == c && preNum >= i) {
                break;
            }
            isVisited[i] = true;
            dfs(pattern, index + 1, temp + i, isVisited);
            isVisited[i] = false;
        }
    }

}
