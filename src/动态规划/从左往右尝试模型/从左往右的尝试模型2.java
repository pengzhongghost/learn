package 动态规划.从左往右尝试模型;

public class 从左往右的尝试模型2 {

    /**
     *  背包问题
     * 给定两个长度都为N的数组weights和values
     * weights[i]和values[i]分别代表 i号物品的重量和价值。
     * 给定一个正数bag，表示一个载重bag的袋子你装的物品不能超过这个重量。
     * 返回你能装下最多的价值是多少?
     */
    public static void main(String[] args) {

    }

    private static int res;

    public static int getMaxValue(int[] weight, int[] value, int bag) {

        return res;
    }

    private static void dfs(int[] weight, int[] value, int bag, int index, int curWeight, int curValue) {
        if (index >= weight.length) {
            return;
        }


    }

}
