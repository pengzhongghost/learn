package leetcode题目.图;

public class 生命游戏 {
    /**
     * https://leetcode-cn.com/problems/game-of-life/
     * 生命游戏
     * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
     * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
     * 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）
     * 的细胞都遵循以下四条生存定律：
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
     * 其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
     * <p>
     * 示例 1：
     * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
     * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
     */
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int[] row = {0, -1, 1, 0, -1, -1, 1, 1};
        int[] col = {-1, 0, 0, 1, 1, -1, -1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + row[k];
                    int y = j + col[k];
                    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                        continue;
                    }
                    //board[x][y]==1的记录在cnt上
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) == 1) {
                    //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    if (cnt >= 2 && cnt <= 3) {
                        //todo 之所以采用0b11是为了不影响其他
                        board[i][j] = 0b11;
                    }
                } else if (cnt == 3) {
                    //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    board[i][j] = 0b10;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
