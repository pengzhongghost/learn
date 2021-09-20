package leetcode题目.图.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * <p>
     * 值0代表空单元格；
     * 值1代表新鲜橘子；
     * 值2代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * <p>
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
     */
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
//        grid = new int[][]{
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}
//        };
//        grid = new int[][]{
//                {0, 2}
//        };
        int i = orangesRotting(grid);
        System.out.println(i);
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //LinkedList实现了deque，deque继承了queue
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        int[] row = {-1, 0, 0, 1};
        int[] column = {0, -1, 1, 0};
        //污染的层数
        int floor = 0;
        int i;
        int j;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            i = poll[0];
            j = poll[1];
            floor = poll[2];
            for (int k = 0; k < 4; k++) {
                int x = i + row[k];
                int y = j + column[k];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y, floor + 1});
                }
            }
        }
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (grid[k][l] == 1) {
                    return -1;
                }
            }
        }
        return floor;
    }
}
