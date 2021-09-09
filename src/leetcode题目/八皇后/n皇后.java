package leetcode题目.八皇后;

import java.util.ArrayList;
import java.util.List;

public class n皇后 {
    /**
     * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
     * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        placeQueen(new int[n], 0, list);
        return list;
    }

    public static void placeQueen(int[] arr, int n, List<List<String>> list) {
        if (n == arr.length) {
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                char[] chars = new char[n];
                for (int j = 0; j < chars.length; j++) {
                    chars[j]='.';
                }
                chars[arr[i]]='Q';
                list1.add(String.valueOf(chars));
            }
            list.add(list1);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[n] = i;
            if (check(arr, n)) {
                placeQueen(arr, n + 1, list);
            }
        }
    }

    public static boolean check(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

}
