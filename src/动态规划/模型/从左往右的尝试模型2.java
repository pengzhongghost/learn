package 动态规划.模型;

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

    private static int dfs(int[] weight, int[] value, int bag, int index, int curWeight) {
        if (index >= weight.length) {
            return 0;
        }
        if (curWeight > bag) {
            //相当于对于价值-1
            return -1;
        }
        //p1不会为-1，因为curWeight没有变
        int p1 = dfs(weight, value, bag, index + 1, curWeight);
        int p2Next = dfs(weight, value, bag, index + 1, curWeight);
        int p2 = -1;
        //为-1则不加上当前的价值
        if (-1 != p2Next) {
            p2 = value[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    private static void dfs02(int[] weight, int[] value, int bag, int index, int curWeight, int curValue) {
        if (curWeight <= bag) {
            res = Math.max(res, curValue);
        }
        if (curWeight > bag) {
            return;
        }
        for (int i = index; i < weight.length; i++) {
            dfs02(weight, value, bag, i + 1, curWeight + weight[i], curValue + value[i]);
        }
    }

    private static int dfs03(int[] weight, int[] value, int index, int restWeight){
        if (restWeight <= 0 || index >= weight.length) {
            return 0;
        }
        int p1 = dfs03(weight, value, index + 1, restWeight);
        int p2 = 0;
        if (restWeight >= weight[index]) {
            p2 = value[index] + dfs03(weight, value, index + 1, restWeight - weight[index]);
        }
        return Math.max(p1, p2);
    }

}
