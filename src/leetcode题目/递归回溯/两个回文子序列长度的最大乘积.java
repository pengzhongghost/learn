package leetcode题目.递归回溯;

public class 两个回文子序列长度的最大乘积 {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/?envType=problem-list-v2&envId=backtracking
     */

    static int maxProduct = 0;
    public static int maxProduct(String s) {
        dfs(s, "", "", 0);
        return maxProduct;
    }

    private static void dfs(String s, String s1, String s2, int index) {
        if(isHuiWen(s1, 0, s1.length() - 1) && isHuiWen(s2, 0, s2.length() - 1)) {
            maxProduct = Math.max(maxProduct, s1.length() * s2.length());
        }
        if(index >= s.length()) {
            return;
        }
        char c = s.charAt(index);
        dfs(s, s1 + c, s2, index + 1);
        dfs(s, s1, s2 + c, index + 1);
        dfs(s, s1, s2, index + 1);
    }

    private static boolean isHuiWen(String str, int i, int j) {
        if("".equals(str)) {
            return false;
        }
        if(str.charAt(i) != str.charAt(j)) {
            return false;
        }
        if(j - i < 3) {
            return true;
        }
        return isHuiWen(str, i + 1, j - 1);
    }

}
