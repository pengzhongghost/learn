package leetcode题目.图.dfs;

public class 省份数量 {
    /**
     * https://leetcode-cn.com/problems/bLyHh0/
     * 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     * 返回矩阵中 省份 的数量。
     * <p>
     * 示例 1：
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     */
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int res = 0;
        //todo dfs算法将所有此节点连通的点设置为已访问
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(isConnected, isVisited, i);
                res++;
            }
        }
        return res;
    }

    public static void dfs(int[][] isConnected, boolean[] isVisited, int index) {
        for (int i = 0; i < isConnected[index].length; i++) {
            if (!isVisited[i] && isConnected[index][i] == 1) {
                isVisited[i] = true;
                dfs(isConnected, isVisited, i);
            }
        }
    }
}
