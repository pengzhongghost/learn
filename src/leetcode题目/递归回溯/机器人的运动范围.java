package leetcode题目.递归回溯;

public class 机器人的运动范围 {

    /**
     * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
     * 剑指 Offer 13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
     * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * <p>
     * 示例 1：
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     */
    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, m, n, k, isVisited);
    }

    public static int dfs(int i, int j, int m, int n, int k, boolean[][] isVisited) {
        if (i >= m || j >= n || isVisited[i][j] || check(i, j, k)) {
            return 0;
        }
        isVisited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, isVisited) + dfs(i, j + 1, m, n, k, isVisited);
    }

    public static boolean check(int i, int j, int k) {
        int x = i / 10 + i % 10;
        int y = j / 10 + j % 10;
        return x + y > k;
    }
}
