package leetcode题目.动态规划;

public class 最佳买卖股票时机含冷冻期 {

    /**
     * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * <p>
     * 示例:
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    //使用变量优化dp数组
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //手上持有股票
        int price01 = -prices[0];
        //手上没有股票并且处于冷冻期
        int price02 = 0;
        //手上没有股票并且不处于冷冻期
        int price03 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp01 = price01;
            price01 = Math.max(price01, price03 - prices[i]);
            int temp02 = price02;
            price02 = temp01 + prices[i];
            price03 = Math.max(price03, temp02);
        }
        return Math.max(price02, price03);
    }

    //推导过程
    public static int maxProfit01(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        //买入股票
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //手上持有股票：1，昨天买的 2，今天刚买的
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            //手上没有股票：卖掉了股票
            f[i][1] = f[i - 1][0] + prices[i];
            //手上没有股票：1.之前卖掉了股票 2.没有任何操作
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

}
