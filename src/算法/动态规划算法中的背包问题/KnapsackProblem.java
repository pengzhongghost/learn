package 算法.动态规划算法中的背包问题;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        //物品的重量
        int[] weight = {1, 4, 3};
        //物品的价值
        int[] value = {1500, 3000, 2000};
        //背包的容量
        int m = 4;
        //物品的数量
        int n = value.length;
        //创建表格 v[i][j]表示在前i个商品中能够装入容量为j的背包中的价值
        int[][] v = new int[n + 1][m + 1];
        //初始化第一行和第一列，不用处理，默认就是0
        //记录放入商品的情况
        int[][] path = new int[n + 1][m + 1];
        //动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //如果物品的重量大于j
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                    //为了记录商品存放到背包的情况,不能直接使用到上面的公式
                    int before = v[i - 1][j];
                    int after = value[i - 1] + v[i - 1][j - weight[i - 1]];
                    if (before < after) {
                        v[i][j] = after;
                        path[i][j] = 1;
                    } else {
                        v[i][j] = before;
                    }
                }
            }
        }
        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个商品放入背包");
                j -= weight[i - 1];//背包重量-放入商品重量
            }
            i--;
        }

    }


}
