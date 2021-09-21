package leetcode题目.递归回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 组合 {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * 提示：
     * 1 <= n <= 20
     * 1 <= k <= n
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     */
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new Stack<>(), res);
        return res;
    }

    //优化版 i <= n - (k - stack.size()) + 1
    /**
     * 例如：n = 6 ，k = 4。
     *
     * path.size() == 1 的时候，接下来要选择 33 个数，搜索起点最大是 44，最后一个被选的组合是 [4, 5, 6]；
     * path.size() == 2 的时候，接下来要选择 22 个数，搜索起点最大是 55，最后一个被选的组合是 [5, 6]；
     * path.size() == 3 的时候，接下来要选择 11 个数，搜索起点最大是 66，最后一个被选的组合是 [6]；
     *
     * 再如：n = 15 ，k = 4。
     * path.size() == 1 的时候，接下来要选择 33 个数，搜索起点最大是 1313，最后一个被选的是 [13, 14, 15]；
     * path.size() == 2 的时候，接下来要选择 22 个数，搜索起点最大是 1414，最后一个被选的是 [14, 15]；
     * path.size() == 3 的时候，接下来要选择 11 个数，搜索起点最大是 1515，最后一个被选的是 [15]；
     *
     */
    public static void dfs(int n, int k, int index, Stack<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i <= n - (k - stack.size()) + 1; i++) {
            stack.push(i);
            dfs(n, k, i + 1, stack, res);
            stack.pop();
        }
    }

    //简单粗暴
    public static void dfs01(int n, int k, int index, Stack<Integer> stack, List<List<Integer>> res) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i <= n; i++) {
            stack.push(i);
            dfs01(n, k, i + 1, stack, res);
            stack.pop();
        }
    }

}
