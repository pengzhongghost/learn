package 中级提升;

import java.util.Arrays;

public class 最小不可组成和_7 {

    /**
     * 给定一个正数数组 arr，其中所有的值都为整数，以下是最小不可组成和的概念:
     * 把 arr每个子集内的所有元素加起来会出现很多值，其中最小的记为 min，
     * 最大的记为max在区间[min,max]上，如果有数不可以被arr某一个子集相加得到，
     * 那么其中最小的那个数是ar!的最小不可组成和在区间[min,max]上，
     * 如果所有的数都可以被arr的某一个子集相加得到，
     * 那么max+1是arr的最小不可组成和请写函数返回正数数组 arr 的最小不可组成和。
     * <p>
     * 【举例】
     * arr=[3,2,5]。子集{2}相加产生 2为 min，子集{3,2,5}相加产生 10为 max。
     * 在区间[2,10]上，4、6和9不能被任何子集相加得到，其中4是arr 的最小不可组成和。
     * 子集{1.2.4}相加产生 7为 max。在区间[1,7]上arr=[1,2,4]。
     * 子集{1}相加产生 1为 min，任何 数都可以被子集相加得到，所以8是arr的最小不可组成和。
     * <p>
     * 【进阶】
     * 如果已知正数数组 arr中肯定有1这个数，是否能更快地得到最小不可组成和?
     */
    public static void main(String[] args) {
        int[] arr = {3,2,5};
        int result = unformedSum(arr);
        System.out.println(result);
    }

    public static int unformedSum(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            minNum = Math.min(minNum, arr[i]);
            sum += arr[i];
        }
        boolean[][] dp = new boolean[arr.length][sum + 1];
        //第0行
        dp[0][arr[0]] = true;
        //第1行开始填
        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col <= sum; col++) {
                if (arr[row] == col) {
                    dp[row][col] = true;
                } else if (dp[row-1][col]) {
                    dp[row][col] = true;
                } else if (col > arr[row] && dp[row - 1][col - arr[row]]) {
                    dp[row][col] = true;
                }
            }
        }
        //最后返回最小的false的累加和
        for (int col = minNum; col <= sum ; col++) {
            if (!dp[arr.length - 1][col]) {
                return col;
            }
        }
        return sum + 1;
    }

    /**
     *【进阶】
     * 如果已知正数数组 arr中肯定有1这个数，是否能更快地得到最小不可组成和?
     */
    public static int unformedSum02(int[] arr) {
        /**
         * 1 1 2 4 5
         */
        Arrays.sort(arr);
        int range = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < range + 1) {
                range += arr[i];
            } else {
                return range + 1;
            }
        }
        return range + 1;
    }

}
