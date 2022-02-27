package leetcode题目.图.dfs;

public class 单词搜索 {
    /**
     * 给定一个'm x n 二维字符网格'board 和一个字符串单词'word 。如果'word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static boolean find = false;

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        board = new char[][]{
//                {'a'}
//        };
        String word = "ABCCED";
        //word = "ABCB";
        //word = "SEE";
        //word = "a";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!find) {
                    dfs(board, word, 0, i, j, isVisited);
                }
            }
        }
        return find;
    }

    public static void dfs(char[][] board, String word, int index, int i, int j, boolean[][] isVisited) {
        if (index == word.length()) {
            find = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (!isVisited[i][j] && board[i][j] == word.charAt(index)) {
            isVisited[i][j] = true;
            dfs(board, word, index + 1, i + 1, j, isVisited);
            dfs(board, word, index + 1, i, j + 1, isVisited);
            dfs(board, word, index + 1, i - 1, j, isVisited);
            dfs(board, word, index + 1, i, j - 1, isVisited);
            isVisited[i][j] = false;
        }
    }
}
