package leetcode题目.递归回溯;

/**
 * @author pengzhong
 * @since 2024/12/26
 */
public class 最接近目标价格的甜点成本 {

    /**
     *https://leetcode.cn/problems/closest-dessert-cost/description/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        int target = 9;
        int result = closestCost(baseCosts, toppingCosts, target);
        System.out.println(result);
    }

    static int result = Integer.MAX_VALUE;

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            dfs(baseCost, 0, toppingCosts, target);
        }
        return result;
    }

    private static void dfs(int curCost, int index, int[] toppingCosts, int target) {
        if (curCost - target > Math.abs(result - target)) {
            return;
        } else if (Math.abs(curCost - target) < Math.abs(result - target)) {
            result = curCost;
        } else if (Math.abs(curCost - target) == Math.abs(result - target)) {
            result = Math.min(curCost, result);
        }
        if(index == toppingCosts.length) {
            return;
        }
        dfs(curCost + toppingCosts[index] * 2, index + 1, toppingCosts, target);
        dfs(curCost + toppingCosts[index], index + 1, toppingCosts, target);
        dfs(curCost, index + 1, toppingCosts, target);
    }

}
