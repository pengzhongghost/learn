package leetcode题目.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 三角形的最短路径之和 {
    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
     * 示例 2：
     * <p>
     * 输入：triangle = [[-10]]
     * 输出：-10
     */
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list01 = new ArrayList<>();
        list01.add(2);
        List<Integer> list02 = new ArrayList<>();
        list02.add(3);
        list02.add(4);
        List<Integer> list03 = new ArrayList<>();
        list03.add(6);
        list03.add(5);
        list03.add(7);
        List<Integer> list04 = new ArrayList<>();
        list04.add(4);
        list04.add(1);
        list04.add(8);
        list04.add(3);
        triangle.add(list01);
        triangle.add(list02);
        triangle.add(list03);
        triangle.add(list04);
        int min = minimumTotal(triangle);
        System.out.println(min);
    }

    //动态规划
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] f = new int[triangle.size()][triangle.size()];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[triangle.size() - 1][0];
        for (int i = 0; i < triangle.size(); i++) {
            minTotal = Math.min(minTotal, f[triangle.size() - 1][i]);
        }
        return minTotal;
    }
}
