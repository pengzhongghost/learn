package leetcode题目.图;

public class 节点间通路 {
    /**
     * https://leetcode-cn.com/problems/route-between-nodes-lcci/
     * 节点间通路
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     * <p>
     * 示例1:
     * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
     * 输出：true
     * <p>
     * 示例2:
     * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4],
     * [1, 3], [2, 3], [3, 4]], start = 0, target = 4
     * 输出 true
     */
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2}
        };
        int n = 3;
        int start = 0;
        int target = 2;

    }

}
