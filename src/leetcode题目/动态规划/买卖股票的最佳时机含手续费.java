package leetcode题目.动态规划;

public class 买卖股票的最佳时机含手续费 {
    /**
     * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     * 示例 1：
     * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出：8
     * 解释：能够达到的最大利润:
     * 在此处买入prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
     * <p>
     * 示例 2：
     * 输入：prices = [1,3,7,5,10,3], fee = 3
     * 输出：6
     */
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int max = maxProfit03(prices, 2);
        System.out.println(max);
    }

    //贪心算法
    public static int maxProfit03(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }


    //优化dp
    public static int maxProfit02(int[] prices, int fee) {
        int n = prices.length;
        //不持有彩票
        int price01 = 0;
        //持有彩票
        int price02 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int temp01 = price01;
            price01 = Math.max(price01, price02 + prices[i] - fee);
            price02 = Math.max(price02, temp01 - prices[i]);
        }
        return price01;
    }

    //dp
    public static int maxProfit01(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //不持有彩票
        dp[0][0] = 0;
        //持有彩票
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
