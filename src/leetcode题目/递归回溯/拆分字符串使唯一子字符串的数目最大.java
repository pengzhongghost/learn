package leetcode题目.递归回溯;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 拆分字符串使唯一子字符串的数目最大 {

    /**
     * https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/description/?envType=problem-list-v2&envId=backtracking
     */
    int maxLen = 0;
    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet());
        return maxLen;
    }

    private void dfs(String s, int index, Set<String> set) {
        if(index == s.length()) {
            maxLen = Math.max(maxLen, set.size());
            return;
        }
        for(int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if(set.add(str)) {
                dfs(s, i + 1, set);
                set.remove(str);
            }
        }
    }

}
