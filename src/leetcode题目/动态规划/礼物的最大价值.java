package leetcode题目.动态规划;

public class 礼物的最大价值 {
    /**
     * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
     * 礼物的最大价值
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     * 示例 1:
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        grid=new int[][]{
                {1,2,5},
                {3,2,1}
        };
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
