package leetcode题目.动态规划;

public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        //cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int minCost = minCostClimbingStairs(cost);
        System.out.println(minCost);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int[] arr = new int[length];
        arr[0] = arr[1] = 0;
        for (int i = 2; i < length; i++) {
            arr[i] = Math.min(arr[i - 1] + cost[i - 1], arr[i - 2] + cost[i - 2]);
        }
        return arr[length - 1];
    }
}
