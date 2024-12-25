package leetcode题目.递归回溯;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 串联字符串的最大长度 {

    /**
     * https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/?envType=problem-list-v2&envId=backtracking
     */
    int result = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String temp, int index) {
        result = Math.max(result, temp.length());
        for (int i = index; i < arr.size(); i++) {
            if (!isUnique(temp + arr.get(i))) {
                continue;
            }
            dfs(arr, temp + arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String str) {
        Set<Character> set = new HashSet();
        for (char c : str.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

}
