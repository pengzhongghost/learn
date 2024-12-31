package 动态规划.模型;

/**
 * @author pengzhong
 * @since 2024/12/31
 */
public class 寻找业务限制的尝试模型 {

    /**
     * 给定一个数组，代表每个人喝完咖啡准备刷杯子的时间
     * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
     * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
     * “返回让所有咖啡杯变干净的最早完成时间
     * 三个参数：int[] drinks、int a、int b：
     */
    /**
     * @param drinks   每个人喝完咖啡的时间点
     * @param a        洗杯子耗费的时间a，固定值
     * @param b        自己挥发干净耗费的时间b，固定值
     * @param index    目前到了谁喝完咖啡
     * @param washLine 上次洗完咖啡的一个时间点
     * @return
     */
    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            return Math.min(Math.max(drinks[index], washLine) + a, drinks[index] + b);
        }
        //第一种情况 使用咖啡机
        int wash = Math.max(drinks[index], washLine) + a;
        //接下来的需要的时间
        int next1 = process(drinks, a, b, index + 1, wash);

        int p1 = Math.max(wash, next1);

        //第二种情况 自然挥发
        int dry = drinks[index] + b;
        //接下来的需要的时间
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }

    /**
     * 改成动态规划
     * index是0到drinks.length - 1
     * washLine是0到
     */
    public static int dp(int[] drinks, int a, int b) {
        //挥发时间比洗的时间还要快
        if (a >= b) {
            return drinks[drinks.length - 1] + b;
        }
        //咖啡机什么时候可用
        int washLineLimit = 0;
        for (int i = 0; i < drinks.length; i++) {
            washLineLimit = Math.max(drinks[i], washLineLimit) + a;
        }
        int[][] dp = new int[drinks.length][washLineLimit + 1];
        //最后一行
        for (int washLine = 0; washLine <= washLineLimit; washLine++) {
            dp[drinks.length - 1][washLine] =
                    Math.min(Math.max(drinks[drinks.length - 1], washLine) + a,
                            drinks[drinks.length - 1] + b);
        }
        //普遍位置
        for (int index = drinks.length - 2; index >= 0; index--) {
            for (int washLine = 0; washLine <= washLineLimit; washLine++) {
                int p1 = Integer.MAX_VALUE;
                //第一种情况 使用咖啡机
                int wash = Math.max(drinks[index], washLine) + a;
                //接下来的需要的时间
                if (wash < washLineLimit) {
                    int next1 = dp[index + 1][wash];
                    p1 = Math.max(wash, next1);
                }
                //第二种情况 自然挥发
                int dry = drinks[index] + b;
                //接下来的需要的时间
                int next2 = dp[index + 1][washLine];
                int p2 = Math.max(dry, next2);
                dp[index][washLine] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] drinks = {1, 1, 5, 5, 7, 10, 12, 12, 12, 12, 12, 12, 15};
        int a = 3;
        int b = 10;
        System.out.println(process(drinks, a, b, 0, 0));
        System.out.println(dp(drinks, a, b));
    }

}
