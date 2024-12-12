package 剑指offer;

public class 衣橱整理 {

    /**
     * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/
     */
    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, cnt, isVisited);
    }

    private int dfs(int i, int j, int cnt, boolean[][] isVisited) {
        if (i >= isVisited.length || j >= isVisited[i].length || isVisited[i][j] || !check(i, j, cnt)) {
            return 0;
        }
        isVisited[i][j] = true;
        return 1 + dfs(i + 1, j, cnt, isVisited) + dfs(i, j + 1, cnt, isVisited);
    }

    private boolean check(int i, int j, int cnt) {
        int x = i / 10 + i % 10;
        int y = j / 10 + j % 10;
        return x + y <= cnt;
    }

}
