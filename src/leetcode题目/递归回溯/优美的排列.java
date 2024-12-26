package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/24
 */
public class 优美的排列 {

    /**
     * https://leetcode.cn/problems/beautiful-arrangement/description/?envType=problem-list-v2&envId=backtracking
     */
    int res = 0;

    public int countArrangement(int n) {
        dfs(n, 1, new boolean[n + 1]);
        return res;
    }

    private void dfs(int n, int index, boolean[] isVisited) {
        if (index > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && (index % i == 0 || i % index == 0)) {
                isVisited[i] = true;
                dfs(n, index + 1, isVisited);
                isVisited[i] = false;
            }
        }

    }
}