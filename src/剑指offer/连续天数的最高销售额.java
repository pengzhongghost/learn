package 剑指offer;

public class 连续天数的最高销售额 {

    /**
     * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/description/
     */
    public int maxSales(int[] sales) {
        int pre = 0, maxSales = sales[0];
        for(int sale: sales) {
            pre = Math.max(pre + sale, sale);
            maxSales = Math.max(maxSales, pre);
        }
        return maxSales;
    }

}
