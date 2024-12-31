package 动态规划;

import java.util.Arrays;

public class 数组中数字组成目标值 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 5};
        int ways = ways(arr, 10);
        int ways01 = ways02(arr, 10);
        int ways03 = ways03(arr, 10);
        int ways04 = ways04(arr, 10);
        System.out.println(ways);
        System.out.println(ways01);
        System.out.println(ways03);
        System.out.println(ways04);
    }

    // arr中都是正数且无重复值，返回组成target的方法数
    public static int ways(int[] arr, int target) {
        if (null == arr || arr.length == 0 || target < 0) {
            return 0;
        }
        return process(arr, 0, target);
    }

    //FIXME 为什么不能这么相加，为什么结果和下面不一样呢
    //一种跳过当前的index
    //一种加上当前的index的才行
    public static int process(int[] arr, int index, int target) {
        if (0 == target) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        if (target >= arr[index]) {
            //一种跳过当前的index
            return process(arr, index + 1, target)
                    //一种加上当前的index的才行
                    + process(arr, index, target - arr[index]);
        }
        return 0;
    }

    public static int ways02(int[] arr, int target) {
        if (null == arr || arr.length == 0 || target < 0) {
            return 0;
        }
        return process02(arr, 0, target);
    }

    public static int process02(int[] arr, int index, int target) {
        if (0 == target) {
            return 1;
        }
        if (index >= arr.length) {
            return 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= target; zhang++) {
            ways += process02(arr, index + 1, target - zhang * arr[index]);
        }
        return ways;
    }

    //记忆化搜索
    public static int ways03(int[] arr, int target) {
        if (null == arr || arr.length == 0 || target < 0) {
            return 0;
        }
        //index = 3, target = 900
        //3_900
        //Map<String, Integer> map = new HashMap<>();
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return process03(arr, 0, target, dp);
    }

    public static int process03(int[] arr, int index, int target, int[][] dp) {
        if (-1 != dp[index][target]) {
            return dp[index][target];
        }
        if (0 == target) {
            dp[index][target] = 1;
            return dp[index][target];
        }
        if (index >= arr.length) {
            dp[index][target] = 0;
            return dp[index][target];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= target; zhang++) {
            ways += process03(arr, index + 1, target - zhang * arr[index], dp);
        }
        dp[index][target] = ways;
        return ways;
    }

    //动态规划
    public static int ways04(int[] arr, int target) {
        if (null == arr || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    //则最终
                    ways += dp[index + 1][rest - zhang * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][target];
    }

    //动态规划优化版本
    public static int ways05(int[] arr, int target) {
        if (null == arr || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                //从上面的循环可知，当前其实是拿的下面的和左侧的相加的
                dp[index][rest] = dp[index][rest + 1];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][target];
    }

}
