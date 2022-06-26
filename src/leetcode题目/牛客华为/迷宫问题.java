package leetcode题目.牛客华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 迷宫问题 {

    /**
     * https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc?tpId=37&tqId=21266&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        List<int[]> result = new ArrayList<>();
        canArrive(maze, 0, 0, result);
        for (int[] ints : result) {
            System.out.println("(" + ints[0] + "," + ints[1] + ")");
        }
        System.out.println("(" + (row - 1) + "," + (col - 1) + ")");
    }

    public static boolean canArrive(int[][] maze, int i, int j, List<int[]> result) {
        if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0 || maze[i][j] == 1) {
            return false;
        }
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            return true;
        }
        maze[i][j] = 1;
        result.add(new int[]{i, j});
        if (canArrive(maze, i + 1, j, result)) {
            return true;
        }
        if (canArrive(maze, i, j + 1, result)) {
            return true;
        }
        if (canArrive(maze, i - 1, j, result)) {
            return true;
        }
        if (canArrive(maze, i, j - 1, result)) {
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }

}
