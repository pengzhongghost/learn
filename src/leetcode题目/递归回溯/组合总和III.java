package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengzhong
 * @since 2024/12/23
 */
public class 组合总和III {

    /**
     * https://leetcode.cn/problems/combination-sum-iii/?envType=problem-list-v2&envId=backtracking
     */

    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, new ArrayList(), 1);
        return result;
    }

    private void dfs(int n, int k, List<Integer> temp, int t) {
        if(temp.size() == k && n == 0) {
            result.add(new ArrayList(temp));
            return;
        }
        if(n < 0) {
            return;
        }
        for(int i = t; i <= 9; i++ ) {
            temp.add(i);
            dfs(n - i, k, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

}
