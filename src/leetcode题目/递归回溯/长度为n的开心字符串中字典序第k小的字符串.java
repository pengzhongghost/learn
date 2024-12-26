package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 长度为n的开心字符串中字典序第k小的字符串 {

    /**
     * https://leetcode.cn/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/?envType=problem-list-v2&envId=backtracking
     */
    int count = 0;
    String result = "";
    public String getHappyString(int n, int k) {
        dfs(n, k, "");
        return result;
    }

    private void dfs(int n, int k, String temp) {
        if(n == temp.length()) {
            count++;
            if(k == count) {
                result = temp;
            }
            return;
        }
        for(int i =0 ;i < 3; i++){
            char curChar = (char)(i + 'a');
            if(!"".equals(temp) && temp.charAt(temp.length() - 1) == curChar) {
                continue;
            }
            dfs(n, k, temp + curChar);
        }
    }

}
