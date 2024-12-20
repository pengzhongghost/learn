package 动态规划;

import java.util.Arrays;

public class 启蒙 {

    public static void main(String[] args) {
        int result = process(7, 3, 3, 2);
        int result2 = process2(7, 3, 3, 2);
        System.out.println(result);
        System.out.println(result2);
    }

    /**
     * 假设有排成一行的N个位置，记为1~N，
     * N一定大于或等于2开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
     * 如果机器人来到1位置，那么下一步只能往右来到2位置;
     * 如果机器人来到N位置，那么下一步只能往左来到N-1位置;
     * 如果机器人来到中间位置，那么下一步可以往左走或者往右走
     * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种给定四个参数 N、M、K、P，返回方法数。
     */

    public static int process(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }


    //TODO 递归法
    /**
     * @param N    位置1~N
     * @param cur  当前位置
     * @param rest 还剩下多少步数
     * @param P    最终固定位置
     * @return
     */
    public static int walk(int N, int cur, int rest, int P) {
        if (0 == rest) {
            return cur == P ? 1 : 0;
        }
        if (1 == cur) {
            return walk(N, cur + 1, rest - 1, P);
        }
        if (N == cur) {
            return walk(N, cur - 1, rest - 1, P);
        }
        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }

    public static int process2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        //两个条件
        //位置1 ~ N
        //只能走K步
        int[][] dp = new int[N + 1][K + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return walk2(N, M, K, P, dp);
    }

    //TODO dp法
    /**
     * @param N    位置1~N
     * @param cur  当前位置
     * @param rest 还剩下多少步数
     * @param P    最终固定位置
     * @return
     */
    public static int walk2(int N, int cur, int rest, int P, int[][] dp) {
        if (-1 != dp[cur][rest]) {
            return 0;
        }
        if (0 == rest) {
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if (1 == cur) {
            dp[cur][rest] = walk2(N, cur + 1, rest - 1, P, dp);
            return dp[cur][rest];
        }
        if (N == cur) {
            dp[cur][rest] = walk2(N, cur - 1, rest - 1, P, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = walk2(N, cur + 1, rest - 1, P, dp) + walk2(N, cur - 1, rest - 1, P, dp);
        return dp[cur][rest];
    }



}
