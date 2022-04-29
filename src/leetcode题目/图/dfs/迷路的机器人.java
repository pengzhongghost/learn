package leetcode题目.图.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 迷路的机器人 {
    /**
     * 迷路的机器人
     * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
     * 设计一种算法，寻找机器人从左上角移动到右下角的路径。网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
     * <p>
     * 示例 1:
     * 输入:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
     * 解释:
     * 输入中标粗的位置即为输出表示的路径，即
     * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
     * 说明：r 和 c 的值均不超过 100。
     */
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(pathWithObstacles(obstacleGrid));
    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(obstacleGrid, 0, 0, result);
        return result;
    }

    public static boolean dfs(int[][] obstacleGrid, int i, int j, List<List<Integer>> result) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] != 0) {
            return false;
        }
        obstacleGrid[i][j] = 1;
        result.add(Arrays.asList(i, j));
        //todo 走到终点了，直接返回
        if (i == obstacleGrid.length - 1 & j == obstacleGrid[0].length - 1) {
            return true;
        }
        //todo 向右走
        if (dfs(obstacleGrid, i + 1, j, result)) {
            return true;
        }
        //输入：[[0,1]] 输出：[]
        //todo 向右走不通向下走
        if (dfs(obstacleGrid, i, j + 1, result)) {
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }
}
