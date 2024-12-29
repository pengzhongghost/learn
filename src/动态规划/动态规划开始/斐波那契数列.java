package 动态规划.动态规划开始;

public class 斐波那契数列 {

    public static void main(String[] args) {

    }

    /**
     * 递归版本
     * 大量的重复计算
     * @param N
     * @return
     */
    public static int dfs(int N) {
        if (1 == N) {
            return 1;
        }
        if (2 == N) {
            return 1;
        }
        return dfs(N - 1) + dfs(N - 2);
    }



}
