package leetcode题目.递归回溯;

public class 公平分发饼干 {

    /**
     * https://leetcode.cn/problems/fair-distribution-of-cookies/description/?envType=problem-list-v2&envId=backtracking
     */

    public static void main(String[] args) {
        int[] cookies = {8, 15, 10, 20, 8};
        int result = distributeCookies(cookies, 2);
        System.out.println(result);
    }

    static int ans = Integer.MAX_VALUE;

    public static int distributeCookies(int[] cookies, int k) {
        int[] count = new int[k];
        dfs(cookies, count, k, 0, 0);
        return ans;
    }

    public static void dfs(int[] cookies, int[] count, int k, int index, int max) {
        if (index == cookies.length) {
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            count[i] += cookies[index];
            dfs(cookies, count, k, index + 1, Math.max(max, count[i]));
            count[i] -= cookies[index];
            //剪枝，如果回溯之后变成0，下一次就要放其它空的地方，其实效果是一样的，因为每个人都是等价的
            //一个小朋友没有分到饼干，则下一个分到了再做比较没什么意义
            if (count[i] == 0) {
                break;
            }
        }
    }

}
