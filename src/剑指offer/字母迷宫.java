package 剑指offer;

public class 字母迷宫 {

    public static void main(String[] args) {
        char[][] grid = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        boolean result = wordPuzzle(grid, "ABCB");
        System.out.println(result);
    }

    /**
     * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/description/
     */

    static boolean find = false;

    public static boolean wordPuzzle(char[][] grid, String target) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!find) {
                    dfs(grid, i, j, 0, target, isVisited);
                }
            }
        }
        dfs(grid, 0, 0, 0, target, isVisited);
        return find;
    }

    private static void dfs(char[][] grid, int i, int j, int index, String target, boolean[][] isVisited) {
        if (index == target.length()) {
            find = true;
            return;
        }
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (!isVisited[i][j] && grid[i][j] == target.charAt(index)) {
            isVisited[i][j] = true;
            dfs(grid, i + 1, j, index + 1, target, isVisited);
            dfs(grid, i - 1, j, index + 1, target, isVisited);
            dfs(grid, i, j + 1, index + 1, target, isVisited);
            dfs(grid, i, j - 1, index + 1, target, isVisited);
            isVisited[i][j] = false;
        }

    }

}
