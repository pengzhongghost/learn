package 剑指offer;

/**
 * @author pengzhong
 * @since 2024/12/19
 */
public class 买卖芯片的最佳时机 {

    /**
     * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
     */

    public int bestTiming(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfit =0;
        int i = 0;
        while(i < prices.length) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
            i++;
        }
        return maxProfit;
    }

}
