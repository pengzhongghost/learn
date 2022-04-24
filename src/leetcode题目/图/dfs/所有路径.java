package leetcode题目.图.dfs;

import java.util.ArrayList;
import java.util.List;

public class 所有路径 {
    /**
     * 所有路径
     * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
     * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：
     * 有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
     * <p>
     * 示例 1：
     * 输入：graph = [[1,2],[3],[3],[]]
     * 输出：[[0,1,3],[0,2,3]]
     * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
     */
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(0, graph, result, res);
        return result;
    }

    public static void dfs(int index, int[][] graph, List<List<Integer>> result, List<Integer> res) {
        if (index == graph.length - 1) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int num : graph[index]) {
            res.add(num);
            dfs(num, graph, result, res);
            res.remove(res.size() - 1);
        }
    }
}
