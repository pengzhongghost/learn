package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 构建字典序最大的可行序列 {

    /**
     * https://leetcode.cn/problems/construct-the-lexicographically-largest-valid-sequence/description/?envType=problem-list-v2&envId=backtracking
     */
    boolean find = false;
    int[] result;
    boolean[] isVisited;
    public int[] constructDistancedSequence(int n) {
        result = new int[2*n-1];
        isVisited = new boolean[n];
        dfs(n, 0);
        return result;
    }

    private void dfs(int n, int index) {
        if(index == 2*n-1) {
            find = true;
            return;
        }
        if(result[index] != 0) {
            dfs(n, index + 1);
            return;
        }
        for(int i = n; i > 0; i--) {
            int next = i == 1 ? index : index + i;
            if(next >= 2*n -1 || isVisited[i-1] || result[next] != 0) {
                continue;
            }
            isVisited[i-1] = true;
            result[index] = i;
            result[next] = i;
            dfs(n, index);
            if(!find) {
                isVisited[i-1] = false;
                result[index] = 0;
                result[next] = 0;
            }
        }

    }


}
