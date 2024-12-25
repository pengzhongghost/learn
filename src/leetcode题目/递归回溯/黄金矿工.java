package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/25
 */
public class 黄金矿工 {

    /**
     * https://leetcode.cn/problems/path-with-maximum-gold/?envType=problem-list-v2&envId=backtracking
     */

    int result = 0;
    public int getMaximumGold(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(0 == grid[i][j]) {
                    continue;
                }
                result = Math.max(result, dfs(grid, i, j, isVisited));
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] isVisited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length
                || 0 == grid[i][j] || isVisited[i][j]) {
            return 0;
        }
        isVisited[i][j] = true;
        int result = grid[i][j];
        int result01 = dfs(grid, i + 1, j, isVisited);
        int result02 = dfs(grid, i, j + 1, isVisited);
        int result03 = dfs(grid, i - 1, j, isVisited);
        int result04 = dfs(grid, i, j - 1, isVisited);
        isVisited[i][j] = false;
        return result + Math.max(result01, Math.max(result02, Math.max(result03, result04)));
    }

}
